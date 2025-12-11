import org.Mahmoud.Assignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssignmentTest {

    @Test
    public void testConstructor() {
        Assignment assignment = new Assignment("analysis", 10.0);

        assertNotNull(assignment.getAssignmentId());
        assertTrue(assignment.getAssignmentId().startsWith("A"));

        assertEquals("Analysis",  assignment.getAssignmentName());
        assertEquals(10.0, assignment.getWeight());
        assertNotNull(assignment.getScores());
    }

    @Test
    public void testCalcAssignmentAvg() {
        Assignment assignment = new Assignment("Exam", 35.0);

        assertEquals(0.0, assignment.calcAssignmentAvg());

        assignment.getScores().add(70);
        assignment.getScores().add(70);
        assignment.getScores().add(100);

        assertEquals(80.0, assignment.calcAssignmentAvg());

        assignment.getScores().clear();

        assignment.getScores().add(70);
        assignment.getScores().add(null);
        assignment.getScores().add(100);

        assertEquals(85.0, assignment.calcAssignmentAvg());
    }

    @Test
    public void testGenerateRandomScore() {
        Assignment assignment = new Assignment("Exam", 25.0);

        assignment.getScores().add(null);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        assignment.generateRandomScore();

        assertEquals(3, assignment.getScores().size());
        assertNotNull(assignment.getScores().getFirst());
        assertNotNull(assignment.getScores().get(1));
        assertNotNull(assignment.getScores().getLast());
    }
}
