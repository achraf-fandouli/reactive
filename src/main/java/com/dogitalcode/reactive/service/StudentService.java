package com.dogitalcode.reactive.service;

import com.dogitalcode.reactive.model.Student;
import com.dogitalcode.reactive.model.StudentRequest;
import com.dogitalcode.reactive.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Mono<Student> save(StudentRequest studentRequest) {
        return studentRepository.save(
                Student.builder()
                        .firstname(studentRequest.getFirstname())
                        .lastname(studentRequest.getLastname())
                        .age(studentRequest.getAge())
                        .build()
        );
    }

    public Flux<Student> findALl() {
        return studentRepository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Flux<Student> findByFirstname(String firstname) {
        return studentRepository.findAllByFirstnameContainingIgnoreCase(firstname);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id).subscribe();
    }

}
