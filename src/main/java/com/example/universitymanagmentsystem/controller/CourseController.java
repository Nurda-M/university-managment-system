import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final Map<Integer, String> courses = new HashMap<>();
    private int idCounter = 1;

    // GET all courses
    @GetMapping
    public List<String> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    // GET course by id
    @GetMapping("/{id}")
    public String getCourseById(@PathVariable int id) {
        return courses.get(id);
    }

    // POST create course
    @PostMapping
    public String createCourse(@RequestBody String courseName) {
        courses.put(idCounter++, courseName);
        return courseName;
    }

    // PUT update course
    @PutMapping("/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody String courseName) {
        courses.put(id, courseName);
        return courseName;
    }

    // DELETE course
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courses.remove(id);
    }
}