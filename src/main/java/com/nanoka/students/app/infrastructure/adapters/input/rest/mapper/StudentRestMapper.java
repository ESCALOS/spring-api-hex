package com.nanoka.students.app.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nanoka.students.app.domain.model.Student;
import com.nanoka.students.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.nanoka.students.app.infrastructure.adapters.input.rest.model.response.StudentResponse;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

    Student toStudent(StudentCreateRequest student);

    StudentResponse toStudentResponse(Student student);

    List<StudentResponse> toStudentResponseList(List<Student> studentList);
}
