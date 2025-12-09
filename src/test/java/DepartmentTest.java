import org.Mahmoud.Department;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
