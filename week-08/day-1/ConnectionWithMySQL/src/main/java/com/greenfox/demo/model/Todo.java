package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public boolean urgent = false;
    public boolean done = false;

    public Todo(String title) {
        this.title = title;
    }

    public Todo() {
    }

    public Todo(String title, boolean urgent, boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done = done;
    }

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Assignee assignee;

}
