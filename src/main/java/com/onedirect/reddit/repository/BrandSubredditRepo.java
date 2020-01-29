package com.onedirect.reddit.repository;

import com.onedirect.reddit.dto.SubredditNameDTO;
import com.onedirect.reddit.entity.SubredditModel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BrandSubredditRepo extends CrudRepository<SubredditModel,Integer> {

  //  @Query("select p from SubredditModel p where p.subreddits = ?")
  //  SubredditModel findByDisplay_name(String uriName);
}
