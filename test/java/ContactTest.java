
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    Contact contact;

    @BeforeEach
    public void setup() {
        contact = new Contact("testID", "Joe", "Grzywinski", "111-111", "1 Main street");
    }
    // first name tests
    @Test
    public void setFirstNameTest_ok() {
        contact.setFirstName("Joseph");
        assertEquals("Joseph", contact.getFirstName());
    }

    @Test
    public void setFirstNameTest_null() {
        String newFirstName = null;
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(newFirstName));
    }

    @Test
    public void setFirstNameTest_longerThan10() {
        String newFirstName = "TooLongName";
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(newFirstName));
    }

    // contactid tests

    @Test
    public void setContactId_ok() {
        contact.setContactID("123456789");
        assertEquals("123456789", contact.getContactID());
    }

    @Test
    public void setContactId_null(){
        String newContactId = null;
        assertThrows(IllegalArgumentException.class, ()  -> contact.setContactID(newContactId));
    }

    @Test
    public void setContactId_longerThan10() {
        String newContactId = "1234567891011";
        assertThrows(IllegalArgumentException.class, () -> contact.setContactID(newContactId));
    }
    // last name tests
    @Test
    public void setLastName_ok() {
        contact.setLastName("Grzywinski");
        assertEquals("Grzywinski", contact.getLastName());
    }

    @Test
    public void setLastName_null(){
        String newLastName = null;
        assertThrows(IllegalArgumentException.class, ()  -> contact.setLastName(newLastName));
    }

    @Test
    public void setLastName_longerThan10() {
        String newLastName = "Grzywinskiii";
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(newLastName));
    }

    // phone number tests
    @Test
    public void setPhoneNumber_ok() {
        contact.setPhoneNumber("2039999999");
        assertEquals("2039999999", contact.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber_null(){
        String newPhoneNumber = null;
        assertThrows(IllegalArgumentException.class, ()  -> contact.setPhoneNumber(newPhoneNumber));
    }

    @Test
    public void setPhoneNumber_longerThan10() {
        String newPhoneNumber = "120399999999";
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(newPhoneNumber));
    }
    // address tests
    @Test
    public void setAddress_ok() {
        contact.setAddress("1 main street");
        assertEquals("1 main street", contact.getAddress());
    }

    @Test
    public void setAddress_null(){
        String newAddress = null;
        assertThrows(IllegalArgumentException.class, ()  -> contact.setAddress(newAddress));
    }

    @Test
    public void setAddress_longerThan10() {
        String newAddress = "1 main street suit 102 floor 13";
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(newAddress));
    }
}
