package com.greenfox.demo.service;

import com.greenfox.demo.model.Post;
import com.greenfox.demo.repository.RedditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RedditService {

    RedditRepository redditRepository;

    @Autowired
    public RedditService(RedditRepository redditRepository) {

        this.redditRepository = redditRepository;
    }

    public List<Post> getPostListInOrder(Long pageNumber) {
        long step;
        if (pageNumber != null) {
            step = ((pageNumber * 10) - 10);
        } else {
            step = 0L;
        }
        List<Post> postListInOrder = (List<Post>) redditRepository.findAll();
        postListInOrder = postListInOrder.stream()
                .sorted(Comparator.comparing(Post::getRating).reversed())
                .skip(step)
                .collect(Collectors.toList());
        postListInOrder = postListInOrder.stream().limit(10).collect(Collectors.toList());

        return postListInOrder;
    }

//    @Query( value = "SELECT * FROM post ORDER BY rating DESC", nativeQuery = true)
//    List<Post> allPostByRating(); Ez arra jó, mint a getPostListInOrder csak nem kell bele annyi stream

    public void addNewPost(Post post) {
        redditRepository.save(post);
    }
    //save it from johny because johny can use POSTMAN ao I have to protect the backend not just the front

    public void ratingUp(Long id) {
        if (redditRepository.findById(id).isPresent()) {
            Optional<Post> toDownVote = redditRepository.findById(id);
            if (toDownVote.isPresent()) {
                Post toSave = toDownVote.get();
                toSave.setRating(toSave.getRating() + 1);
                redditRepository.save(toSave);
            }
        }
    }

    public void ratingDown(Long id) {
        if (redditRepository.findById(id).isPresent()) {
            Optional<Post> toDownVote = redditRepository.findById(id);
            if (toDownVote.isPresent()) {
                Post toSave = toDownVote.get();
                toSave.setRating(toSave.getRating() - 1);
                redditRepository.save(toSave);
            }
        }
    }

    public List<Long> getPagesList() {
        List<Long> pageList = new ArrayList<>();
        List<Post> pageCounter = (List<Post>) redditRepository.findAll();
        int databaseSize = Math.toIntExact(pageCounter.size());
        int pageNumbers = 0;
        if (databaseSize > 10) {
            pageNumbers = databaseSize / 10;
            if (databaseSize % 10 != 0) {
                pageNumbers += 1;
            }
        }
        for (int i = 0; i < pageNumbers; i++) {
            pageList.add(i + 1L);
        }
        return pageList;
    }

}
