package com.example.eregistrar.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class StudentRequest {

    private Long studentNumber;
    private String name;
    private double cgpa;
    private LocalDate admissionDate;


    public StudentRequest getStudentRequest(){
        return this;
    }


}
