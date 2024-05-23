package Github_200days.employees_advanced_oop.main;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
    protected final DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    public static final Pattern peoplePat = Pattern.compile(regex);
    protected final Matcher peopleMat;
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    protected String lastName;
    protected String firstName;
    protected String dob;


    public Employee() {
        peopleMat = null;
        firstName = "NA";
        lastName = "NA";
        dob = null;
    }

    protected Employee(String personText) {
        peopleMat = Employee.peoplePat.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = String.valueOf(LocalDate.from(dtformatter.parse(peopleMat.group("dob"))));
        }
    }

    public static final IEmployee createEmployee(String employeeText) {
        Matcher peopleMat = Employee.peoplePat.matcher(employeeText);

        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> () -> 0;//method that takes no input and returns 0 or 1 output
            };
        } else {
            return () -> 0;
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

    private static final class DummyEmployee extends Employee implements IEmployee {
        @Override
        public int getSalary() {
            return 0;
        }
    }


}
