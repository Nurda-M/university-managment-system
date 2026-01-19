package src;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create pools
        DataPool<Student> studentPool = new DataPool<>();
        DataPool<Professor> professorPool = new DataPool<>();
        DataPool<Course> coursePool = new DataPool<>();

        // Courses
        Course math = new Course("C101", "Mathematics", 5);
        Course prog = new Course("C102", "Programming", 6);
        coursePool.add(math);
        coursePool.add(prog);

        // Students
        Student s1 = new Student("S001", "Alice", 2);
        s1.enroll(math);
        s1.enroll(prog);

        Student s2 = new Student("S002", "Bob", 1);
        s2.enroll(prog);

        studentPool.add(s1);
        studentPool.add(s2);

        // Professors
        Professor p1 = new Professor("P001", "Dr. Ivanov", "PhD", "Mathematics");
        Professor p2 = new Professor("P002", "Dr. Petrov", "PhD", "Computer Science");
        professorPool.add(p1);
        professorPool.add(p2);

        // Filtering: students enrolled in Programming
        List<Student> progStudents = studentPool.filter(s -> s.getCourses().stream().anyMatch(c -> c.getId().equals("C102")));
        System.out.println("Students in Programming: " + progStudents);

        // Searching: find professor by department
        List<Professor> csProfessors = professorPool.search(p -> "Computer Science".equals(p.getDepartment()));
        System.out.println("CS Professors: " + csProfessors);

        // Sorting: students by name ascending
        List<Student> sortedStudents = studentPool.sort(Comparator.comparing(Student::getName), true);
        System.out.println("All students sorted by name: " + sortedStudents);

        // Demonstrating findById
        studentPool.findById("S001").ifPresent(s -> System.out.println("Found student S001: " + s.getSummary()));
    }
}