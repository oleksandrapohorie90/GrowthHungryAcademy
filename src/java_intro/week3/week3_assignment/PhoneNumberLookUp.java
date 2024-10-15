package java_intro.week3.week3_assignment;

import java.util.HashMap;

public class PhoneNumberLookUp {

    HashMap<String,String> phones = new HashMap<>();

    public String displayPhoneNumber(Contact contact){
        for (String name : phones.keySet()){
            if(phones.get(contact.name).equals(name)){
                return phones.get(contact.name);
            }
        }
        return "No Contact phone number was found";
    }

    public void updatePhoneNumber(Contact contact, String updatedPhoneNumber){
        phones.put(contact.name, updatedPhoneNumber);
    }
}
