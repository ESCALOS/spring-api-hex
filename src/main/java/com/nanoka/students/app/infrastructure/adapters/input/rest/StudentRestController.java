package com.nanoka.students.app.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nanoka.students.app.application.ports.input.StudentServicePort;
import com.nanoka.students.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.nanoka.students.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.nanoka.students.app.infrastructure.adapters.input.rest.model.response.StudentResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentRestController {
    private final StudentServicePort servicePort;
    private final StudentRestMapper restMapper;

    @GetMapping
    public List<StudentResponse> findAll() {
        return restMapper.toStudentResponseList(servicePort.findAll());
    }

    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return restMapper.toStudentResponse(servicePort.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(
                        servicePort.save(restMapper.toStudent(request))));
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request) {
        return restMapper.toStudentResponse(
                servicePort.update(id, restMapper.toStudent(request)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePort.delete(id);
    }
}