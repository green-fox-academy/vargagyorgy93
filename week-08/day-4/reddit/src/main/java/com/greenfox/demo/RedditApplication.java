package com.greenfox.demo;

import com.greenfox.demo.repository.RedditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

    public RedditRepository redditRepository;

    @Autowired
    public RedditApplication(RedditRepository redditRepository) {
        this.redditRepository = redditRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
