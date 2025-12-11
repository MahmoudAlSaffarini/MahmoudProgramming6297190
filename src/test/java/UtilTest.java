import org.Mahmoud.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UtilTest {

    @Test
    public void testToTitleCase() {
        assertEquals("Computer Science", Util.toTitleCase("computer science"));
        assertEquals("Mahmoud Al Saffarini", Util.toTitleCase("mAHMOUD aL sAfFarinI"));
        assertEquals("Programming",  Util.toTitleCase("programming"));

        assertEquals("", Util.toTitleCase(""));
        assertNull(Util.toTitleCase(null));
        assertEquals("", Util.toTitleCase("        "));
    }
}
