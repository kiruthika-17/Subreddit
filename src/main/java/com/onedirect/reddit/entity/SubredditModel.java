package com.onedirect.reddit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="SubredditList")
public class SubredditModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="Subreddits")
    private String display_name;


}
