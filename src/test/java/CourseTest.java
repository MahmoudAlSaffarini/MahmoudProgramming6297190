import org.Mahmoud.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    public void testCourse() {
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void testConstructor() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        assertTrue(course.getCourseId().startsWith("C"));
        assertNotNull(course.getCourseId());
        assertEquals("Introduction To Programming", course.getCourseName());
        assertNotNull(course.getDepartment());
        assertNotNull(course.getRegisteredStudents());
    }

    @Test
    public void testIsAssignmentWeightValid() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        course.addAssignment("Exam 1", 50.0);
        course.addAssignment("Assignments", 50.0);

        assertTrue(course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentWeightInvalid() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        course.addAssignment("Exam 1", 50.0);
        course.addAssignment("Assignments", 40.0);

        assertFalse(course.isAssignmentWeightValid());
    }

    @Test
    public void registerStudent() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");
        Student registeringStudent = new Student("Mahmoud", Gender.MALE, address, department);

        course.addAssignment("Exam 1", 50.0);

        boolean result = course.registerStudent(new Student("Mahmoud", Gender.MALE, address, department));

        assertTrue(result);
        assertEquals(1, course.getRegisteredStudents().size());

        List<Assignment> assignments = course.getAssignments();
        assertEquals(1, assignments.size());

        Assignment newAssignment = assignments.getFirst();

        assertEquals(1, newAssignment.getScores().size());
    }

    @Test
    public void testAddAssignment() {
        Department department = new Department("Computer Science and Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");
        course.registerStudent(new Student("Mahmoud", Gender.MALE, address, department));

        course.addAssignment("Exam 1", 50.0);

        List<Assignment> assignments = course.getAssignments();
        assertEquals(1, assignments.size());

        Assignment newAssignment = assignments.getFirst();

        assertEquals(1, newAssignment.getScores().size());
     }


}
