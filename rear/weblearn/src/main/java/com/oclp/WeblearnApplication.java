package com.oclp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)

public class WeblearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeblearnApplication.class, args);
    }

}
