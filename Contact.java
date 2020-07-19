package Section8_Arrays_JavaInbuiltList_AutoUnbox.ArrayListChallenge;

public class Contact {

// fields

    private String contactName;
    private String phoneNumber;         // here we use String for phoneNumber 后面输入scanner时方便一些

// constructor

    public Contact(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

// methods

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String contactName, String phoneNumber) {
        return new Contact(contactName, phoneNumber);   // calls the constructor to create a contact return it.
    }
}
