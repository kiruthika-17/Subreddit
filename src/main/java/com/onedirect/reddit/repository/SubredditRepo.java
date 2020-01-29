package com.onedirect.reddit.repository;

import com.onedirect.reddit.entity.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubredditRepo extends CrudRepository<Model,Integer> {

    Optional<Model> findByName(String name);

}
