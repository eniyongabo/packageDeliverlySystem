package com.example.eregistrar.service;


import com.example.eregistrar.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);
    Classroom getClassroomById(int id);
}
