import org.Mahmoud.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest {

    @Test
    public void testAddress() {

        assertTrue(Address.isPostalCodeValid("A1B2C3"));
        assertTrue(Address.isPostalCodeValid("a1b2c3"));
        assertFalse(Address.isPostalCodeValid("A1B2C"));
        assertFalse(Address.isPostalCodeValid(null));
        assertFalse(Address.isPostalCodeValid("&&&&"));
    }
}
