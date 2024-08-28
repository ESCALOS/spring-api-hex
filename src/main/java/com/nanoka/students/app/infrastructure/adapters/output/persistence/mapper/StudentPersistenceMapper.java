package com.nanoka.students.app.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nanoka.students.app.domain.model.Student;
import com.nanoka.students.app.infrastructure.adapters.output.persistence.entity.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {
    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity entity);

    List<Student> toStudentList(List<StudentEntity> entityList);
}
