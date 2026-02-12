import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses;

    public CourseService() {
        this.courses = new ArrayList<>();
    }

    // Create a new course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Read all courses
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    // Update a course
    public boolean updateCourse(String courseId, Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getId().equals(courseId)) {
                courses.set(i, updatedCourse);
                return true;
            }
        }
        return false;
    }

    // Delete a course
    public boolean deleteCourse(String courseId) {
        return courses.removeIf(course -> course.getId().equals(courseId));
    }
}