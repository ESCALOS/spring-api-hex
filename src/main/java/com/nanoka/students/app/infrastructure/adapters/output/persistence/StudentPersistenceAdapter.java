package com.nanoka.students.app.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nanoka.students.app.application.ports.output.StudentPersistencePort;
import com.nanoka.students.app.domain.model.Student;
import com.nanoka.students.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.nanoka.students.app.infrastructure.adapters.output.persistence.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository repository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return mapper.toStudentList(repository.findAll());
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(
                repository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
