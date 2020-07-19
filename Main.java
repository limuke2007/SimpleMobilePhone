package Section8_Arrays_JavaInbuiltList_AutoUnbox.ArrayListChallenge;

import java.util.Scanner;

public class Main {

    private static Scanner scanner=new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("405-439-4859");

    public static void main(String[] args) {

        boolean quit=false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action=scanner.nextInt();
            scanner.nextLine();     // handle Enter key issue

            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit=true;
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }


    private static void addNewContact() {
        System.out.print("Enter new contact name: ");
        String newContactName = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName, newPhoneNumber);    // static method "createCon"
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + newContactName + ", phone number: " + newPhoneNumber);
        } else {
            System.out.println("Cannot add, " + newContactName + " already on file" );
        }
    }

    private static void updateExistingContact() {
        System.out.print("Enter existing contact name: ");
        String existingContactName = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(existingContactName);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newContactName = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName, newPhoneNumber);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.print("Enter the contact name to be removed: ");
        String removeContactName = scanner.nextLine();
        Contact removeContact = mobilePhone.queryContact(removeContactName);
        if (removeContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        if(mobilePhone.removeContact(removeContact)) {
            System.out.println("Successfully removed contact");
        } else {
            System.out.println("Error removing contact.");
        }
    }

    private static void queryContact() {
        System.out.print("Enter the contact name: ");
        String queryName = scanner.nextLine();
        Contact queryContact = mobilePhone.queryContact(queryName);
        if (queryContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + queryName + ", phone number is: " + queryContact.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress ");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts\n" +
                           "2 - to add a new contact\n" +
                           "3 - to update an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query if a contact exists\n" +
                           "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}
