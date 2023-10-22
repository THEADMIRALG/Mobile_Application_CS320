
import java.util.ArrayList;

public class ContactService {

    static ArrayList<Contact> contactList = new ArrayList<Contact>();




    public void addContact(Contact newContact) {
        if (contactList.stream().noneMatch(c -> c.getContactID().equals(newContact.getContactID()))) {
            contactList.add(newContact);
        }
    }


    public void delete(String id) {
        contactList.remove(contactList.stream().filter(c -> c.getContactID().equals(id)).findFirst().orElse(null));
    }


    public void updateContact(Contact updateContact) {
        Contact matchingContact = contactList.stream().filter(c -> c.getContactID().equals(updateContact.getContactID())).findFirst().orElse(null);
        if(matchingContact != null) {
            matchingContact.setAddress(updateContact.getAddress());
            matchingContact.setFirstName(updateContact.getFirstName());
            matchingContact.setLastName(updateContact.getLastName());
            matchingContact.setPhoneNumber(updateContact.getPhoneNumber());
        }
        else{
            throw new IllegalArgumentException("Contact Id not found.");
        }
    }

}





