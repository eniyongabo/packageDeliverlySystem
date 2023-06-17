package miu.edu.cs425.eregistrar.service;




import jakarta.validation.constraints.NotNull;
import miu.edu.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    List<Student> getPassingStudentsOnly();
    List<Student> getLatestStudents();
    Student getStudentById(Long id);
    void updateStudent(Student student1, Long studentId);
    void deleteStudentById(Long studentId);
    List<Student> searchStudents(Student student);

}
