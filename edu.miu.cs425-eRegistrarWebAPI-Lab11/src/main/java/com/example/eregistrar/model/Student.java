package com.example.eregistrar.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull(message = "student Number cannot be null, blank or an empty string")
    private int studentNumber;
    @NotBlank(message = "student fName cannot be null, blank or an empty string")
    private String fname;
    private String mName;
    @NotBlank(message = "student lName cannot be null, blank or an empty string")
    private String lName;
    private double cgpa;
    @NotNull(message = " EnrollmentDate cannot be null, blank or an empty string")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate EnrollmentDate;

    @NotNull(message = "isInternational cannot be null, blank or an empty string")
    private String isInternational;

    public Student() {
    }

    public Student(Long studentId, int studentNumber, String fname, String mName, String lName, double cgpa, LocalDate enrollmentDate, String isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.fname = fname;
        this.mName = mName;
        this.lName = lName;
        this.cgpa = cgpa;
        EnrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return EnrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        EnrollmentDate = enrollmentDate;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }
}
