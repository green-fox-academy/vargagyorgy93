package com.greenfox.demo.repository;

import com.greenfox.demo.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditRepository extends CrudRepository<Post, Long> {
}
