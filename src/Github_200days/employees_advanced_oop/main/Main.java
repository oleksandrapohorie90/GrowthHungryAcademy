package Github_200days.employees_advanced_oop.main;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=3000,yoe=14,iq=100}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                Flinstone, Wilma, 3/3/1910, Analyst,{projectCount=9}
                Rubble, Betty, 4/4/1915, CEO,{avgStockPrice=300}
                """;
        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
        Pattern peoplePat = Pattern.compile(regex);
        Matcher peopleMat = peoplePat.matcher(peopleText);
        String progRegex = "\\w+=(?<locpd>\\w),\\w+=(?<yoe>\\w),\\w+=(?<iq>\\w)";
        Pattern coderPat = Pattern.compile(progRegex);

        String mngrRegex = "\\w+\\=(?<orgSize>\\w+)\\,\\w+\\=(?<dr>\\w+)";
        Pattern mngrPat = Pattern.compile(progRegex);


        int totalSalaries = 0;
        Employee employee = null;
        while (peopleMat.find()) {
            employee = switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(peopleMat.group());
                case "Manager" -> new Manager(peopleMat.group());
                //case "Analyst" -> new Analyst(peopleMat.group());
                //case "CEO" -> new Analyst(peopleMat.group());
                default -> null;//OR -> new Employee(peopleMat.group()); //create a new class NOBODY with getSalary()=0
            };

            if (employee != null) {
                System.out.println(employee.toString());
                totalSalaries += employee.getSalary();
            }
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
    }

}

