package com.example.demo;


import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

public class HelloController {

    public String index(){
        return "Hello world";
    }
}
