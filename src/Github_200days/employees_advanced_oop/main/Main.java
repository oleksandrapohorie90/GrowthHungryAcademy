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


        int totalSalaries = 0;
        while (peopleMat.find()) {
            totalSalaries +=
                    switch (peopleMat.group("role")) {
                        case "Programmer" -> {
                            String details = peopleMat.group("details");

                            Matcher coderMat = coderPat.matcher(details);
                            //need to tell to code to find smth
                            if (coderMat.find()) {
                                int locpd = Integer.parseInt(coderMat.group("locpd"));
                                int yoe = Integer.parseInt(coderMat.group("yoe"));
                                int iq = Integer.parseInt(coderMat.group("iq"));
                                System.out.printf("Programmer loc: %s yoe: %s iq: %s%n", coderMat.group("locpd"), coderMat.group("yoe"), coderMat.group("iq"));
                            }
                            yield 3000;
                        }
                        case "Manager" -> {
                            yield 3500;
                        }
                        case "Analyst" -> {
                            yield 2500;
                        }
                        case "CEO" -> {
                            yield 5000;
                        }
                        default -> 0;
                    };
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
    }

}

