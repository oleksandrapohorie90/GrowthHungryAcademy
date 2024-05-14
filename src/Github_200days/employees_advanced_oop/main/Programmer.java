package Github_200days.employees_advanced_oop.main;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer {
    private String lastName;
    private String firstName;
    private LocalDate dob;

    String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    Pattern peoplePat = Pattern.compile(regex);
    Matcher peopleMat = peoplePat.matcher(peopleText);

    public Programmer(String personText) {



    }
}
