package miu.edu.cs425.eregistrar.service;


import miu.edu.cs425.eregistrar.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);
    Classroom getClassroomById(int id);
}
