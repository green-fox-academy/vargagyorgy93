package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Assignee {
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "assignee")
    private List<Todo> todoList;

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Assignee() {
    }
}
