package edu.mum.cs.cs425.demowebapps.eregistrar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Classroom;
import edu.mum.cs.cs425.demowebapps.eregistrar.repository.ClassroomRepository;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Override
    public Classroom addNewClassroom(Classroom classroom) {
        var newClassroom = classroomRepository.save(classroom);
        return newClassroom;
    }

    @Override
    public List<Classroom> getAllClassroom() {
        var classrooms = classroomRepository.findAll();
        return classrooms;
    }

}
