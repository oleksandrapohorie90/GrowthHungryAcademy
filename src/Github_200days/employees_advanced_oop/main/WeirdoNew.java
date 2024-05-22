package Github_200days.employees_advanced_oop.main;

import java.time.LocalDate;

public record WeirdoNew(String lastName, String firstName, LocalDate dob) implements Apple {
    //no abstraction, can create a record as a nested class, streamline versions of classes, cant extend classes
    public WeirdoNew(String lastName, String firstName) {
        this(lastName, firstName, LocalDate.of(1994, 10, 10));
    }

    public String sayHello() {
        return "Hello World";
    }
}

