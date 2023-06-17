package miu.edu.cs425.eregistrar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name="student_number", unique = true)
    private Long studentNumber;
    @NotBlank(message = "student Name cannot be null, blank or an empty string")
   @Column(nullable = false)
    private String name;
    private Float cgpa;

    @Column(name = "admission_date")
    private LocalDate admissionDate;
    @NotNull
    private Boolean isInternational;

    @OneToOne
    @JoinColumn(name="transcript_id", nullable = false, unique = true)
//    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Transcript transcript;

    @ManyToOne()
    @JoinColumn(name = "classroom_id", nullable = true)
    private Classroom classroom;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="students_courses",
            joinColumns={@JoinColumn(name="student_id", referencedColumnName="student_id")},
            inverseJoinColumns={@JoinColumn(name="course_id", referencedColumnName="course_id")})
    private List<Course> courses;

    public Student() {
    }


    public Student(Long studentId, Long studentNumber, String name, Float cgpa, LocalDate admissionDate, Transcript transcript, Classroom cr) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.name = name;
        this.cgpa = cgpa;
        this.admissionDate = admissionDate;
        this.transcript = transcript;
        this.classroom = cr;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                ", admissionDate=" + admissionDate +
                ", " + transcript +
                ", " + classroom +
                '}';
    }
}
