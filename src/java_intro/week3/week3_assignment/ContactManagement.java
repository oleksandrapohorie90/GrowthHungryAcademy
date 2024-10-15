package java_intro.week3.week3_assignment;

import java.util.ArrayList;

public class ContactManagement {
    public ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        //check for duplicates based on name
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(contact.getName())) {
                System.out.println("Contact already exists!");
                return;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added: " + contact);
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available!");
        } else {
           for(Contact c : contacts){
               System.out.println(c);
           }
        }
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

}
