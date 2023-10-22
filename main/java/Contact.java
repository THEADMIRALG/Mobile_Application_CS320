public class Contact {

    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }



    public void setContactID (String contactID) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("ID does not fulfill requirements.");
        }
        else {
            this.contactID = contactID;
        }
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name does not fulfill requirements.");
        }
        else {
            this.firstName = firstName;
        }
    }



    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name does not fulfill requirements.");
        }
        else {
            this.lastName = lastName;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() > 10) {
            throw new IllegalArgumentException("Phone Number does not fulfill requirements.");
        }
        else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address does not fulfill requirements.");
        }
        else {
            this.address = address;
        }
    }
}
