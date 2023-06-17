package miu.edu.cs425.eregistrar.service.impl;



import miu.edu.cs425.eregistrar.model.Student;
import miu.edu.cs425.eregistrar.repository.StudentRepository;
import miu.edu.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> getPassingStudentsOnly() {
        return studentRepository.findAll();
    }



     @Override
    public List<Student> getLatestStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    @Override
    public void updateStudent(Student student, Long studentId) {

        var existingStudent = studentRepository.findById(studentId).get();
        existingStudent.setName(student.getName());
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    @Override
    public List<Student> searchStudents(Student student) {
        return studentRepository.findAll();
    }


}
