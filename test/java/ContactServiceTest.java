
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {
    ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
        // Clear the list so that tests don't affect each other
        ContactService.contactList.clear();
        ContactService.contactList.add(new Contact("1", "Joe1", "Grz1", "111-111", "1 Main street"));
        ContactService.contactList.add(new Contact("2", "Joe2", "Grz2", "222-222", "2 Main street"));
        ContactService.contactList.add(new Contact("3", "Joe3", "Grz3", "333-333", "3 Main street"));
        ContactService.contactList.add(new Contact("4", "Joe4", "Grz4", "444-444", "4 Main street"));
    }
    //add contact tests
    @Test
    public void addContactTest_ok() {
        Contact contactToBeAdded =new Contact("5", "Joe5", "Grz5", "555-555", "5 Main street");
        contactService.addContact(contactToBeAdded);
        assertEquals(5, ContactService.contactList.size());
    }

    @Test
    public void addContactTest_duplicateID() {
        Contact contactToBeAdded =new Contact("1", "Joe1", "Grz1", "111-111", "1 Main street");
        contactService.addContact(contactToBeAdded);
        assertEquals(4, ContactService.contactList.size());
    }
    // delete contact tests
    @Test
    public void deleteContactTest_ok () {
        String deleteId = "1";
        contactService.delete(deleteId);
        assertEquals(3, ContactService.contactList.size());
    }

    @Test
    public void deleteContactTest_noId() {
        String deleteId = "6";
        contactService.delete(deleteId);
        assertEquals(4, ContactService.contactList.size());
    }
    //add contact test
    @Test
    public void updateContactTest_ok () {
        Contact contactToBeUpdated =new Contact("4", "Joe6", "Grz6", "555555555", "5 Main street");
        contactService.updateContact(contactToBeUpdated);
        assertEquals("Joe6", ContactService.contactList.get(3).getFirstName());
        assertEquals("Grz6", ContactService.contactList.get(3).getLastName());
        assertEquals("555555555", ContactService.contactList.get(3).getPhoneNumber());
        assertEquals("5 Main street", ContactService.contactList.get(3).getAddress());

    }
    @Test
    public void updateContactTest_duplicate () {
        Contact contactToBeUpdated =new Contact("5", "Joe6", "Grz6", "555555555", "5 Main street");
        assertThrows(IllegalArgumentException.class, () ->contactService.updateContact(contactToBeUpdated));
    }
}
