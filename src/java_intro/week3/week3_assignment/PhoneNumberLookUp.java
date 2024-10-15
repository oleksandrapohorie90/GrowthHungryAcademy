package java_intro.week3.week3_assignment;

import java.util.HashMap;

public class PhoneNumberLookUp {

    HashMap<String, String> phones = new HashMap<>();

    //to not have an empty map
    public void addContactToPhones(Contact contact) {
        phones.put(contact.getName(), contact.getPhoneNumber());
    }

    public void displayPhoneNumber(String name) {
        if (phones.containsKey(name)) {
            System.out.println("Phone number for " + name + ": " + phones.get(name));
        } else {
            System.out.println("No Contact phone number was found");
        }
    }

    public void updatePhoneNumber(Contact contact, String updatedPhoneNumber) {
        phones.put(contact.getName(), updatedPhoneNumber);
    }
}
