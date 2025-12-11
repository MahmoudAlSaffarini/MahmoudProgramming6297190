import org.Mahmoud.Address;
import org.Mahmoud.Province;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testIsPostalCodeValid() {

        assertTrue(Address.isPostalCodeValid("A1B2C3"));
        assertTrue(Address.isPostalCodeValid("a1b2c3"));
        assertFalse(Address.isPostalCodeValid("A1B2C"));
        assertFalse(Address.isPostalCodeValid(null));
        assertFalse(Address.isPostalCodeValid("&&&&"));
    }

    @Test
    public void testIfConstructorIsValid() {
        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");

        assertEquals(8576, address.getStreetNo());
        assertEquals("Boulevard Henri Bourassa Ouest", address.getStreet());
        assertEquals("Montreal", address.getCity());
        assertEquals(Province.QC, address.getProvince());
        assertEquals("H4S2B2", address.getPostalCode());
    }

    @Test
    public void testIfConstructorIsInvalid() {
        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S 2B2");

        assertEquals(0, address.getStreetNo());
        assertNull(address.getStreet());
        assertNull(address.getCity());
        assertNull(address.getProvince());
        assertNull(address.getPostalCode());
    }

    @Test
    public void testSetPostalCode() {
        Address address = new Address(8576, "Boulevard Henri Bourassa Ouest", "Montreal", Province.QC, "H4S2B2");

        address.setPostalCode("J7V4S2");
        assertEquals("J7V4S2", address.getPostalCode());

        address.setPostalCode("E3DKJ9");
        assertEquals("J7V4S2", address.getPostalCode());
    }
}
