package com.onedirect.reddit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="Subreddit_Table")
public class Model {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int id;
   @Column(name="SubredditId")
   private String subreddit_id;
   @Column(name="SubredditName")
   private String subreddit;
   @Column(name="Score")
   private int score;
   @Column(name="CreatedUtc")
   private String created_utc;
   @Column(name="Ups")
   private int ups;
   @Column(name="Author")
   private String author_fullname;
   @Column(name="PostId")
   private String name;


   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSubreddit_id() {
      return subreddit_id;
   }

   public void setSubreddit_id(String subreddit_id) {
      this.subreddit_id = subreddit_id;
   }

   public String getSubreddit() {
      return subreddit;
   }

   public void setSubreddit(String subreddit) {
      this.subreddit = subreddit;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   public String getCreated_utc() {
      return created_utc;
   }

   public void setCreated_utc(String created_utc) {
      this.created_utc = created_utc;
   }

   public int getUps() {
      return ups;
   }

   public void setUps(int ups) {
      this.ups = ups;
   }

   public String getAuthor_fullname() {
      return author_fullname;
   }

   public void setAuthor_fullname(String author_fullname) {
      this.author_fullname = author_fullname;
   }



   public Model() {
   }
}
