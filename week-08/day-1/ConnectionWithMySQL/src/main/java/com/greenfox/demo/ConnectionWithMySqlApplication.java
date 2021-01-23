package com.greenfox.demo;

import com.greenfox.demo.model.Assignee;
import com.greenfox.demo.model.Todo;
import com.greenfox.demo.repository.AssigneeRepository;
import com.greenfox.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionWithMySqlApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ConnectionWithMySqlApplication.class, args);
    }

    private Repository repository;
    private AssigneeRepository assigneeRepository;

    @Autowired
    public ConnectionWithMySqlApplication(Repository repository, AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
//        repository.save(new Todo("I have to learn Object Relational Mapping"));
//        repository.save(new Todo("Eat"));
//        repository.save(new Todo("Sleep"));
//        repository.save(new Todo("Jump", true, true));
//        repository.save(new Todo("Draw", true, true));
//        assigneeRepository.save(new Assignee("Mari", "mari@greenfox.com"));
    }

}
