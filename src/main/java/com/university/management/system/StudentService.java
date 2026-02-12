package com.university.management.system;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private DataPool dataPool;

    public StudentService(DataPool dataPool) {
        this.dataPool = dataPool;
    }

    public void createStudent(Student student) {
        dataPool.addStudent(student);
    }

    public Student getStudent(int id) {
        return dataPool.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(dataPool.getAllStudents());
    }

    public void updateStudent(int id, Student student) {
        dataPool.updateStudent(id, student);
    }

    public void deleteStudent(int id) {
        dataPool.removeStudent(id);
    }
}