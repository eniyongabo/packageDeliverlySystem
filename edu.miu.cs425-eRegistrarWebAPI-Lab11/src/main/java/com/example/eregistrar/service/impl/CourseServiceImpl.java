package com.example.eregistrar.service.impl;


import com.example.eregistrar.model.Course;
import com.example.eregistrar.repository.CourseRepository;
import com.example.eregistrar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
