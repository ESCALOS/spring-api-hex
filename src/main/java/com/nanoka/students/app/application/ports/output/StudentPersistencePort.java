package com.nanoka.students.app.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.nanoka.students.app.domain.model.Student;

public interface StudentPersistencePort {
    Optional<Student> findById(Long id);

    List<Student> findAll();

    Student save(Student student);

    void deleteById(Long id);
}
