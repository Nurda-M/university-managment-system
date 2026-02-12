package com.university.management.system;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            // Update more fields as needed
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        students.removeIf(student -> student.getId() == id);
    }
}