package com.university.management.system;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public ApplicationRunner dataInitializer(StudentRepository studentRepository, ProfessorRepository professorRepository, CourseRepository courseRepository) {
        return args -> {
            // Initialize Sample Data

            // Sample Students
            List<Student> students = List.of(
                new Student("John Doe", "john.doe@example.com"),
                new Student("Jane Smith", "jane.smith@example.com")
            );
            studentRepository.saveAll(students);

            // Sample Professors
            List<Professor> professors = List.of(
                new Professor("Dr. Alice Jones", "alice.jones@university.com"),
                new Professor("Dr. Bob Brown", "bob.brown@university.com")
            );
            professorRepository.saveAll(professors);

            // Sample Courses
            List<Course> courses = List.of(
                new Course("Intro to Computer Science", "CS101"),
                new Course("Data Structures", "CS102"),
                new Course("Algorithms", "CS103")
            );
            courseRepository.saveAll(courses);

            // Link courses and professors if necessary
            // Example: Course course = courses.get(0);
            // course.setProfessor(professors.get(0));
            // courseRepository.save(course);
        };
    }
}