package com.dogitalcode.reactive.controller;

import com.dogitalcode.reactive.model.Student;
import com.dogitalcode.reactive.model.StudentRequest;
import com.dogitalcode.reactive.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> findAll() {
        return studentService.findALl();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Student> create(@RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }

    @GetMapping("/filter")
    public Flux<Student> findByFirstname(@RequestParam String name) {
        return studentService.findByFirstname(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
