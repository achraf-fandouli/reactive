package com.dogitalcode.reactive;

import com.dogitalcode.reactive.model.Student;
import com.dogitalcode.reactive.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			for (int i = 0; i < 3000; i++) {
				repository.save(
						Student.builder()
								.firstname("Achraf" + i)
								.lastname("Fandouli" + i)
								.age(i)
								.build()
				).subscribe();
			}
		};
	}
}
