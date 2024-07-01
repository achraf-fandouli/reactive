package com.dogitalcode.reactive.repository;

import com.dogitalcode.reactive.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

    Flux<Student> findAllByFirstnameContainingIgnoreCase(String firstName);
}
