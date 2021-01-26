package com.greenfox.demo.repositroy;

import com.greenfox.demo.model.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
}
