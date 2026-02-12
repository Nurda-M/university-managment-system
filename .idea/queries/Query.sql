
CREATE TABLE student_courses (
                                 student_id VARCHAR(50) REFERENCES students(id),
                                 course_id VARCHAR(50) REFERENCES courses(id),
                                 PRIMARY KEY (student_id, course_id)
);