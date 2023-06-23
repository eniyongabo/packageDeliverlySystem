package com.example.eregistrar.controller;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public List<Student> students(){
        return studentService.getAllStudents();

    }
    @PostMapping(value = "/register")
    public Student addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping(value = "get/{studentId}")
    public Student getStudentById(@PathVariable  int studentId){
        return studentService.getStudentById(studentId);
    }
    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent( @RequestBody Student student, @PathVariable int studentId){
        return studentService.updateStudent(student,studentId);
    }
    @DeleteMapping(value = {"/delete/{studentId}"})
    public void deleteStudent(@PathVariable int studentId) {
         studentService.deleteStudentById(studentId);

    }
}