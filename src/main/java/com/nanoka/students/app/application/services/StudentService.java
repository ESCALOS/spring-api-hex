package com.nanoka.students.app.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nanoka.students.app.application.ports.input.StudentServicePort;
import com.nanoka.students.app.application.ports.output.StudentPersistencePort;
import com.nanoka.students.app.domain.exception.StudentNotFoundException;
import com.nanoka.students.app.domain.model.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort persistencePort;

    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id)
                .map(savedStudent -> {
                    savedStudent.setFirstname(student.getFirstname());
                    savedStudent.setLastname(student.getLastname());
                    savedStudent.setAge(student.getAge());
                    savedStudent.setAddress(student.getAddress());
                    return persistencePort.save(savedStudent);
                })
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        if (persistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }

        persistencePort.deleteById(id);
    }

}
