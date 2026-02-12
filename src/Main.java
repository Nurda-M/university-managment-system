import java.sql.*;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        DataPool<Student> studentPool = new DataPool<>();
        DataPool<Professor> professorPool = new DataPool<>();
        DataPool<Course> coursePool = new DataPool<>();

        Course math = new Course("C101", "Mathematics", 5);
        Course prog = new Course("C102", "Programming", 6);
        coursePool.add(math);
        coursePool.add(prog);

        Student s1 = new Student("S001", "Alice", 2);
        s1.enroll(math);
        s1.enroll(prog);

        Student s2 = new Student("S002", "Bob", 1);
        s2.enroll(prog);

        studentPool.add(s1);
        studentPool.add(s2);

        Professor p1 = new Professor("P001", "Dr. Ivanov", "PhD", "Mathematics");
        Professor p2 = new Professor("P002", "Dr. Petrov", "PhD", "Computer Science");
        professorPool.add(p1);
        professorPool.add(p2);

        List<Student> progStudents = studentPool.filter(s -> s.getCourses().stream().anyMatch(c -> c.getId().equals("C102")));
        System.out.println("Students in Programming: " + progStudents);

        List<Professor> csProfessors = professorPool.search(p -> "Computer Science".equals(p.getDepartment()));
        System.out.println("CS Professors: " + csProfessors);

        List<Student> sortedStudents = studentPool.sort(Comparator.comparing(Student::getName), true);
        System.out.println("All students sorted by name: " + sortedStudents);

        studentPool.findById("S001").ifPresent(s -> System.out.println("Found student S001: " + s.getSummary()));


        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "nurda0511";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement st = conn.createStatement();

            st.executeUpdate("INSERT INTO students (name) VALUES ('Ivan')");
            System.out.println(" Записали Ивана в базу");

            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Имя: " + rs.getString("name"));
            }

            st.executeUpdate("UPDATE students SET name = 'Nurdaulet_Pro' WHERE name = 'Nurdaulet'");
            System.out.println("Обновили");

            st.executeUpdate("DELETE FROM students WHERE name = 'Ivan'");
            System.out.println("Удалили");

        } catch (SQLException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }


    }
}


