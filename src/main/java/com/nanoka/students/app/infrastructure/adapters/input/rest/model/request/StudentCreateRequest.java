package com.nanoka.students.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank(message = "Field firstname cannot be empty or null")
    private String firstname;

    @NotBlank(message = "Field lastname cannot be empty or null")
    private String lastname;

    @NotNull(message = "Field age cannot be null")
    @Min(value = 0, message = "Field age must be a positive integer")
    private Integer age;

    @NotBlank(message = "Field address cannot be empty or null")
    private String address;
}
