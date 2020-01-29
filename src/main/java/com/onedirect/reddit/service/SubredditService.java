package com.onedirect.reddit.service;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.onedirect.reddit.dto.BrandSubreddits;
import com.onedirect.reddit.dto.SubredditDTO;
import com.onedirect.reddit.dto.SubredditNameDTO;
import com.onedirect.reddit.entity.SubredditModel;
import com.onedirect.reddit.exception.DataNotFoundException;
import com.onedirect.reddit.entity.Model;

import com.onedirect.reddit.repository.BrandSubredditRepo;
import com.onedirect.reddit.repository.SubredditRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.Optional;



@Service
public class SubredditService implements SubredditServiceInterface{

    @Autowired
    private SubredditRepo repo;

     @Autowired
     private BrandSubredditRepo brandrepo;


    @Value("${access_token}")
    private String access_token;

    public ResponseEntity<String> saveSubreddit(SubredditNameDTO names)  throws JSONException, IOException, DataNotFoundException {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("user-agent", "aaa");
        headers.set("authorization", "bearer" + access_token);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


      /* final String SubredditUri="https://oauth.reddit.com/subreddits.json";
        ResponseEntity<String> Subredditresponse
                = restTemplate.exchange(SubredditUri,HttpMethod.GET,entity,String.class);

         if(Objects.nonNull(Subredditresponse)){

            JSONObject Subredditresult = new JSONObject(Subredditresponse.getBody());

            if(Objects.nonNull(Subredditresult)) {

                JSONObject Subredditdata = (JSONObject) Subredditresult.get("data");

                if (Objects.nonNull(Subredditdata)) {

                    JSONArray Subredditchildren = Subredditdata.getJSONArray("children");
                    int length = Subredditchildren.length();

                    String Subredditoutput;

                    List<BrandSubreddits> brandSubreddits=new ArrayList<>();

                    ObjectMapper objectMapper = new ObjectMapper();

                    for (int SubredditCount = 0; SubredditCount < length; SubredditCount++) {
                        JSONObject Subredditno = Subredditchildren.getJSONObject(SubredditCount);
                        JSONObject SpecificSubreddit = (JSONObject) Subredditno.get("data");
                        Subredditoutput = SpecificSubreddit.toString();

                        BrandSubreddits bb=objectMapper.readValue(Subredditoutput,BrandSubreddits.class);
                        brandSubreddits.add(bb);


                    }



                    for (BrandSubreddits sd : brandSubreddits) {
                        SubredditModel sm = new SubredditModel();
                        BeanUtils.copyProperties(sd, sm);
                      //  System.out.println(sm.getDisplay_name());
                        brandrepo.save(sm);


                    }

                }}}

*/

                    String uriName;
        String name = names.getNames();
        String[] arrSplit = name.split(",");
        for (int i = 0; i < arrSplit.length; i++) {
            System.out.println(arrSplit[i]);
            uriName = arrSplit[i];

          //  Optional<SubredditModel> mm = brandrepo.findByDisplay_name(uriName);
          //  if (mm.isPresent()) {

                final String uri = "https://oauth.reddit.com/r/" + uriName + ".json";
                System.out.println(uri);


                ResponseEntity<String> response
                        = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

                if (Objects.nonNull(response)) {
                    JSONObject result = new JSONObject(response.getBody());

                    if (Objects.nonNull(result)) {

                        JSONObject data = (JSONObject) result.get("data");

                        if (Objects.nonNull(data)) {

                            JSONArray children = data.getJSONArray("children");
                            int postlength = children.length();

                            String output;
                            List<SubredditDTO> subredditList = new ArrayList<SubredditDTO>();

                            ObjectMapper objectMapper = new ObjectMapper();
                            for (int postCount = 0; postCount < postlength; postCount++) {
                                JSONObject post = children.getJSONObject(postCount);
                                JSONObject ans = (JSONObject) post.get("data");
                                output = ans.toString();
                                subredditList.add(objectMapper.readValue(output, SubredditDTO.class));
                            }

                            List<Model> model = new ArrayList<Model>();

                            for (SubredditDTO d : subredditList) {
                                Model m = new Model();
                                BeanUtils.copyProperties(d, m);
                                model.add(m);
                                saveUniqueRecord(m);

                            }

                        } else {
                            throw new DataNotFoundException("There exists no post under this Subreddit");
                        }

                    } else {
                        throw new DataNotFoundException("There exists no post under this Subreddit");
                    }
                } else {
                    throw new DataNotFoundException("There exists no post under this Subreddit");
                }
            }


        return new ResponseEntity<String>("Posts are stored successfully", HttpStatus.OK);

    }

    private void saveUniqueRecord(Model m) {
        Optional<Model> model= repo.findByName(m.getName());
        if(!model.isPresent()) {

            try {
                repo.save(m);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }


}
