package com.reddit.RedditProject.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reddit.RedditProject.DTO.SubredditDTO;
import com.reddit.RedditProject.Model.Model;
import com.reddit.RedditProject.Repository.SubredditRepo;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class SubredditService {

    @Autowired
    SubredditRepo repo;
    public ResponseEntity<String> saveSubreddit(String subreddit_name) throws JSONException, IOException {

  //  String uri = "https://www.reddit.com/r/worldnews.json";

        String uri = "https://www.reddit.com/r/"+subreddit_name+".json";

     //System.out.println(uri);
     RestTemplate restTemplate = new RestTemplate();
     HttpHeaders headers = new HttpHeaders();
     headers.set("user-agent","aaa");
    //   headers.set("authorization","bearer 430456666949-lRCyhs7DgRMvYyzcvDPYtbmrs6I") ;
     HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);
       // System.out.println(uri);
     ResponseEntity<String> response
                = restTemplate.exchange(uri,HttpMethod.GET,entity,String.class);
     JSONObject result = new JSONObject(response.getBody());
    if(result!=null) {
        JSONObject data = (JSONObject) result.get("data");
        if(data!=null) {
            JSONArray children = data.getJSONArray("children");
            int length = children.length();
            String output;
            List<SubredditDTO> subredditList = new ArrayList<SubredditDTO>();

            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < length; i++) {
                JSONObject post = children.getJSONObject(i);
                JSONObject ans = (JSONObject) post.get("data");
                Object aObj = ans.get("created_utc");
                if(aObj instanceof Integer){
                    System.out.println(aObj);
                }

                output = ans.toString();
                subredditList.add(objectMapper.readValue(output, SubredditDTO.class));

            }


            List<Model> model = new ArrayList<Model>();

            for (SubredditDTO d : subredditList) {
                Model m = new Model();
                BeanUtils.copyProperties(d, m);
                model.add(m);
                System.out.println(m.getName());
                repo.save(m);
            }

        }
    }
        return new ResponseEntity<String>("status", HttpStatus.OK);

    }

}
