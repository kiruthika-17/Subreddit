package com.onedirect.reddit.service;

import com.onedirect.reddit.dto.SubredditNameDTO;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SubredditServiceInterface {

    ResponseEntity<String> saveSubreddit(SubredditNameDTO name) throws JSONException, IOException;

}
