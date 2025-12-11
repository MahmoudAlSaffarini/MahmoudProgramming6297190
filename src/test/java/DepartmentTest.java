import org.Mahmoud.Department;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    @Test
    public void testIsDepartmentNameValid() {
        assertTrue(Department.isDepartmentNameValid("Computer Science and Mathematics"));
        assertTrue(Department.isDepartmentNameValid("General Chemistry"));
        assertFalse(Department.isDepartmentNameValid(""));
        assertFalse(Department.isDepartmentNameValid(null));
        assertFalse(Department.isDepartmentNameValid("Calculus 1"));
        assertFalse(Department.isDepartmentNameValid("Computer!Science!and!Mathematics"));
    }

    @Test
    public void testConstructorValid() {
        Department department = new Department("computer science and mathematics");

        assertNotNull(department.getDepartmentId());
        assertFalse(department.getDepartmentId().startsWith("C"));
        assertEquals("Computer Science And Mathematics", department.getDepartmentName());
    }

    @Test
    public void testConstructorInvalid() {
        Department department = new Department("Health and Life Sciences 200.B0");

        assertNull(department.getDepartmentId());
        assertNull(department.getDepartmentName());
    }
}
