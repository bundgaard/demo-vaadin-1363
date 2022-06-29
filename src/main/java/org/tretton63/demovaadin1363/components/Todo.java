package org.tretton63.demovaadin1363.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tretton63.demovaadin1363.repositories.CustomerRepository;

@Component
public class Todo {

private final CustomerRepository repository;

    public Todo(CustomerRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedDelay = 15_000)
    public void checkDatabase(){
        System.out.println("Checking database");
        repository.findAll().forEach(System.out::println);
    }

}
