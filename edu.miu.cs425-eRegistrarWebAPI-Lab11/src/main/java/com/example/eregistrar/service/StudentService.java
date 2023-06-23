package com.example.eregistrar.service;



import com.example.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> getAllStudents();
    public abstract Student addStudent(Student s);
    public abstract Student getStudentById(int id);
    public abstract Student updateStudent(Student student1, int studentId);

    public abstract void deleteStudentById(int studentId);

}
