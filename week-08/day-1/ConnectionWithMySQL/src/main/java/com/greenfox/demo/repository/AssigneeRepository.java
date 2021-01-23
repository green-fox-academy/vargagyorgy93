package com.greenfox.demo.repository;

import com.greenfox.demo.model.Assignee;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
}
