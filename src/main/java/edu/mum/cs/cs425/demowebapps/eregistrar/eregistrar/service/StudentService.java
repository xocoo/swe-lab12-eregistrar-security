package edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.service;

import java.util.List;

import edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.model.Student;

public interface StudentService {
    public abstract Student addNewStudent(Student student);

    public abstract List<Student> getAllStudents();

    public abstract Student getStudentById(Long studentId);

    Student updatetStudent(Student updateStudent);

    void deleteStudentById(Long studentId);
}
