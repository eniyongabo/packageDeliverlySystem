package miu.edu.cs425.eregistrar.service.impl;



import miu.edu.cs425.eregistrar.model.Classroom;
import miu.edu.cs425.eregistrar.repository.ClassroomRepository;
import miu.edu.cs425.eregistrar.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom save(Classroom cr) {
        return classroomRepository.save(cr);
    }

    @Override
    public Classroom getClassroomById(int id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
