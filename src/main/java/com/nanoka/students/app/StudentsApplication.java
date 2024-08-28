package com.nanoka.students.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nanoka.students.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.nanoka.students.app.infrastructure.adapters.output.persistence.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentsApplication implements CommandLineRunner {

	private final StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity> entities = Arrays
				.asList(
						new StudentEntity(null, "Carlos", "Escate", 25, "Av. 28 de Julio N° 104"),
						new StudentEntity(null, "Juan", "Perez", 30, "Av. 2 de Mayo N° 452"),
						new StudentEntity(null, "Maria", "Gonzales", 28, "Ca. Lima N° 323"),
						new StudentEntity(null, "Pedro", "Lopez", 35, "Av. Municipalidad N° 231"));
		repository.saveAll(entities);
	}

}
