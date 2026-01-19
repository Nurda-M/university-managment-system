public class Course {
    private String title;
    private int credits;

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String toString() {
        return "Course Title: " + title + " | Credits: " + credits;

    }
}