package Github_200days.employees_advanced_oop.main;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {
    protected final DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    protected final Pattern peoplePat = Pattern.compile(regex);
    protected final Matcher peopleMat;
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    protected String lastName;
    protected String firstName;
    protected String dob;

    public Employee(String personText) {
        peopleMat = peoplePat.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = String.valueOf(LocalDate.from(dtformatter.parse(peopleMat.group("dob"))));
        }
    }


    public abstract int getSalary();

    public double getBonus() {
        return getSalary() * 1.10;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", lastName, firstName, moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }
}
