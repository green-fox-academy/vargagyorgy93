package com.greenfox.demo.model;

import com.greenfox.demo.repositroy.LogRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
public class Entries {

    private List<Log> entries;
    private Integer entryCount = 0;

    public Entries(List<Log> entries) {
        this.entries = entries;
        this.entryCount = entries.size();
    }
}
