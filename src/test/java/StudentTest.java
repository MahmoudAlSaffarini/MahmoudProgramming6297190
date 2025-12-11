import org.Mahmoud.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testConstructor() {
        Department department = new Department("Computer Science And Mathematics");
        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");

        Student student = new Student("Mahmoud Al Saffarini", Gender.MALE, address, department);

        assertNotNull(student.getStudentId());
        assertTrue(student.getStudentId().startsWith("S"));

        assertEquals("Mahmoud Al Saffarini", student.getStudentName());
        assertTrue(student.getRegisteredCourses().isEmpty());
    }

    @Test
    public void testRegisterCourse() {
        Department department = new Department("Computer Science And Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");
        Student student = new Student("Mahmoud Al Saffarini", Gender.MALE, address, department);

        boolean response1 = student.registerCourse(course);
        assertTrue(response1);
        assertEquals(1, student.getRegisteredCourses().size());

        boolean response2 = student.registerCourse(course);
        assertFalse(response2);

        assertEquals(1, student.getRegisteredCourses().size());
    }

    @Test
    public void testDropCourse() {
        Department department = new Department("Computer Science And Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");
        Student student = new Student("Mahmoud Al Saffarini", Gender.MALE, address, department);

        student.registerCourse(course);

        boolean generate1 = student.dropCourse(course);
        assertTrue(generate1);
        assertEquals(0, student.getRegisteredCourses().size());

        boolean generate2 = student.dropCourse(course);
        assertFalse(generate2);
    }

    @Test
    public void toSimplifiedString() {
        Department department = new Department("Computer Science And Mathematics");
        Course course = new Course("Introduction To Programming", 3.33, department);

        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");
        Student student = new Student("Mahmoud Al Saffarini", Gender.MALE, address, department);

        String simplifiedString = student.toSimplifiedString();

        assertTrue(simplifiedString.contains(student.getStudentId()));
        assertTrue(simplifiedString.contains("Mahmoud Al Saffarini"));
        assertTrue(simplifiedString.contains("Computer Science And Mathematics"));
    }
}
