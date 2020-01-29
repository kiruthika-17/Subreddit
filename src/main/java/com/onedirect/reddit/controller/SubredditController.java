package com.onedirect.reddit.controller;

import com.onedirect.reddit.exception.JsonErrorClass;
import com.onedirect.reddit.dto.SubredditNameDTO;
import com.onedirect.reddit.exception.DataNotFoundException;
import com.onedirect.reddit.service.SubredditServiceInterface;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
public class SubredditController {

    @Autowired
    private SubredditServiceInterface subredditService;

    @RequestMapping(value="/savesubreddit",method = RequestMethod.GET)
    public ResponseEntity<String> saveSubreddit(@RequestBody SubredditNameDTO names) throws JSONException, IOException {
        return subredditService.saveSubreddit(names);
    }
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<JsonErrorClass> toResponse(DataNotFoundException e) throws Exception{
        JsonErrorClass ec=new JsonErrorClass(404,e.getMessage());
        System.out.println("ccc");
        return new ResponseEntity<JsonErrorClass>(ec, HttpStatus.NOT_FOUND);
    }

}
