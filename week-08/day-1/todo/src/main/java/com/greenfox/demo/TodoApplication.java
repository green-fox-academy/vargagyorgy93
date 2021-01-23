package com.greenfox.demo;

import com.greenfox.demo.model.Todo;
import com.greenfox.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    private Repository repository;

    @Autowired
    public TodoApplication(Repository repository) {
        this.repository = repository;
    }
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Todo("I have to learn Object Relational Mapping"));
        repository.save(new Todo("Eat"));
        repository.save(new Todo("Sleep"));
    }
}
