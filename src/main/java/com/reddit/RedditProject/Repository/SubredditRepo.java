package com.reddit.RedditProject.Repository;

import com.reddit.RedditProject.Model.Model;
import org.springframework.data.repository.CrudRepository;

public interface SubredditRepo extends CrudRepository<Model,Integer> {
}
