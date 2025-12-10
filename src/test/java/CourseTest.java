import org.Mahmoud.Course;
import org.Mahmoud.Department;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {

    @Test
    public void testIsAssignmentWeightValid() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction to Programming", 3.33, department);

        course.addAssignment("Exam 1", 50.0);
        course.addAssignment("Assignments", 50.0);

        assertTrue(course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentWeightInvalid() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction to Programming", 3.33, department);

        course.addAssignment("Exam 1", 50.0);
        course.addAssignment("Assignments", 40.0);

        assertFalse(course.isAssignmentWeightValid());
    }
}
