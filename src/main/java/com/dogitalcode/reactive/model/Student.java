package com.dogitalcode.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Builder
public class Student {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    private int age;
}
