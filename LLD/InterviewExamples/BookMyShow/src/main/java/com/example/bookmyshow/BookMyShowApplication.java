package com.example.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // for auditing related tasks like createdAt, updatedAt
public class BookMyShowApplication {

    public static void main(String[] args) {
            SpringApplication.run(BookMyShowApplication.class, args);
    }

}
