import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private int year;
    private final List<Course> courses = new ArrayList<>();

    public Student(String id, String name, int year) {
        super(id, name);
        this.year = year;
    }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public List<Course> getCourses() {
        return new ArrayList<>(courses); 
    }

    public void enroll(Course course) {
        Objects.requireNonNull(course);
        if (!courses.contains(course)) courses.add(course);
    }

    public void drop(Course course) {
        courses.remove(course);
    }

    @Override
    public String getSummary() {
        return "Student: " + getName() + " (Year " + year + "), courses=" + courses.size();
    }

    @Override
    public String toString() {
        return "Student{id='" + getId() + "', name='" + getName() + "', year=" + year + ", courses=" + courses + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
