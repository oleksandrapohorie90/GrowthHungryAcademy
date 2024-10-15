package java_intro.week3.week3_assignment;

import java.util.HashSet;

public class UniqueEmailDomains {
    HashSet<String> emailDomains = new HashSet<>();
    ContactManagement cm = new ContactManagement();

    public void extractDomainNames() {
        for (Contact c : cm.contacts) {
            String email = c.getEmail();
            String domain = email.substring(email.indexOf("@") + 1);
            emailDomains.add(domain); //to ad all domains only
        }
    }

    public void displayUniqueDomains() {
        System.out.println("Unique email domains are: " + emailDomains);
    }


}
