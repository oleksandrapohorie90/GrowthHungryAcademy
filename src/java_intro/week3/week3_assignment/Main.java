package java_intro.week3.week3_assignment;

public class Main {
    public static void main(String[] args) {
        ContactManagement cm = new ContactManagement();
        PhoneNumberLookUp pn = new PhoneNumberLookUp();
        UniqueEmailDomains ud = new UniqueEmailDomains();

        cm.addContact(new Contact("olga", "25267689898", "olga2@yahoo.com"));

        cm.addContact(new Contact("tom", "9876780909", "tom1@gmail.com"));

        cm.displayAllContacts();


        pn.displayPhoneNumber("tom");


        ud.extractDomainNames();
    }
}
