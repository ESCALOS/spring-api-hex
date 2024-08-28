package com.nanoka.students.app.application.ports.input;

import java.util.List;

import com.nanoka.students.app.domain.model.Student;

public interface StudentServicePort {

    Student findById(Long id);

    List<Student> findAll();

    Student save(Student student);

    Student update(Long id, Student student);

    void delete(Long id);
}
