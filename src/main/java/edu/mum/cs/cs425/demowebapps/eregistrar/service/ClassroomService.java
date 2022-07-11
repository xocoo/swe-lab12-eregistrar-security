package edu.mum.cs.cs425.demowebapps.eregistrar.service;

import java.util.List;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Classroom;

public interface ClassroomService {
    public abstract Classroom addNewClassroom(Classroom classroom);

    public abstract List<Classroom> getAllClassroom();
}
