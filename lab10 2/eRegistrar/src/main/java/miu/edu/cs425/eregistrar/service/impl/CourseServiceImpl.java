package miu.edu.cs425.eregistrar.service.impl;



import miu.edu.cs425.eregistrar.model.Course;
import miu.edu.cs425.eregistrar.repository.CourseRepository;
import miu.edu.cs425.eregistrar.service.CourseService;
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
