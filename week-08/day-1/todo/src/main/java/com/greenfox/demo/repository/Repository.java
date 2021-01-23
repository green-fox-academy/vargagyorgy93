package com.greenfox.demo.repository;

import com.greenfox.demo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Todo, Long> {
}
