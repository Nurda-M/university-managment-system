import java.util.Objects;

public class Course implements Identifiable{
    private final String id;
    private String title;
    private int credits;

    public Course(String id, String title, int credits) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.title = Objects.requireNonNull(title);
        this.credits = credits;
    }

    public String getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = Objects.requireNonNull(title); }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String toString() {
        return "Course{id='" + id + "', title='" + title + "', credits=" + credits + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;
        return id.equals(course.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
