package com.onedirect.reddit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class SubredditDTO {

    private String subreddit_id;
    private String subreddit;
    private int score;
    private String created_utc;
    private int ups;
    private String author_fullname;
    private String name;


}
