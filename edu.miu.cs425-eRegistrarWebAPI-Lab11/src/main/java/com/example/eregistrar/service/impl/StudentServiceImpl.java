package com.example.eregistrar.service.impl;


import com.example.eregistrar.model.Student;
import com.example.eregistrar.repository.StudentRepository;
import com.example.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("fname"));
    }
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);

    }
    @Override
    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Student student, int studentId) {
        Student existingStudent= studentRepository.getById(studentId);
        existingStudent.setStudentNumber(student.getStudentNumber());
        existingStudent.setFname(student.getFname());
        existingStudent.setEnrollmentDate(student.getEnrollmentDate());
        existingStudent.setIsInternational(student.getIsInternational());
        return studentRepository.save(existingStudent);

    }

    @Override
    public void deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
    }


}
