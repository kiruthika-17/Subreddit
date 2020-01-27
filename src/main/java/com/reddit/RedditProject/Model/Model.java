package com.reddit.RedditProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="subreddit1")
public class Model {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int id;
   private String subreddit_id;
   private String subreddit;
   private int score;
   @Column(name="createdutc")
   private String created_utc;
   private int ups;
   private String author_fullname;
   @Column(name="post_id")
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
