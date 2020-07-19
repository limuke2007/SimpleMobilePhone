package Section8_Arrays_JavaInbuiltList_AutoUnbox.ArrayListChallenge;

import java.util.ArrayList;

public class MobilePhone {

// fields

    private String myNumber;
    private ArrayList<Contact> myContacts;

// constructor

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();     // assign an empty ArrayList to "myContacts" field.
    }


// methods

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getContactName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getContactName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getContactName()) != -1) {
            System.out.println("Contact with name " + newContact.getContactName() +
                                " already exists. Update was not successful.");
            return false;
        }
        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getContactName() + " was replaced with " + newContact.getContactName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact) >= 0) {
            myContacts.remove(contact);
            System.out.println(contact.getContactName() + ", was deleted.");
            return true;
        }
        System.out.println(contact.getContactName() + ", was not found.");
        return false;
    }

    private int findContact (Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact (String contactName) {
        for (int i=0;i<myContacts.size();i++) {
            Contact currentContact = myContacts.get(i);
            if (currentContact.getContactName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getContactName();
        }
        return null;
    }

    public Contact queryContact(String contactName) {
        int position = findContact(contactName);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    public void printContactList() {
        System.out.println("Contact List");
        for (int i = 0; i< myContacts.size(); i++) {
            System.out.println((i + 1) + ". "
                                        + myContacts.get(i).getContactName() + " -> "
                                        + myContacts.get(i).getPhoneNumber());
        }
    }
}
