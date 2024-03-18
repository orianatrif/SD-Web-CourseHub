package com.example.demo;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.demo.entities.Level.BEGINNER;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {
	private final UserRepository userRepository;
	private final CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	void setup(){

		userRepository.save(UserEntity.builder()
				.firstname("Oriana")
				.lastname("Trif")
				.email("oriana@email.com")
				.password("1234")
				.build()
		);

		userRepository.save(UserEntity.builder()
				.firstname("Iulia")
				.lastname("Zdrenghea")
				.email("iulia@email.com")
				.password("0000")
				.build()
		);
		userRepository.save(UserEntity.builder()
				.firstname("Andrei")
				.lastname("Marian")
				.email("andrei@yahool.com")
				.password("7437")
				.build()
		);

		courseRepository.save(CourseEntity.builder()
				.title("Design")
				.description("Design Course")
				.rating(10)
				.assignments("yes")
				.level(BEGINNER)
				.build()
		);

	}


}
