package com.reddit.RedditProject.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reddit.RedditProject.Service.SubredditService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SubredditController {

    @Autowired
    SubredditService subredditService;
    @RequestMapping("/savesubreddit/{subreddit_name}")
    public ResponseEntity<String> saveSubreddit(@PathVariable String subreddit_name) throws JSONException, IOException {
        return subredditService.saveSubreddit(subreddit_name);
    }
}
