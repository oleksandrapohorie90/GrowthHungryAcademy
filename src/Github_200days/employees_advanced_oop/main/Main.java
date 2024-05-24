package Github_200days.employees_advanced_oop.main;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=3000,yoe=14,iq=100}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                Flinstone, Wilma, 3/3/1910, Analyst,{projectCount=9}
                Rubble, Betty, 4/4/1915, CEO,{avgStockPrice=300}
                """;

        Matcher peopleMat = Employee.peoplePat.matcher(peopleText);

        Programmer coder = new Programmer("");
        coder.cook("Hamburger");

        Flyer flyer = new CEO("");
        flyer.fly();
// say more w/ less
        int totalSalaries = 0;
        IEmployee employee = null;
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            if (employee instanceof Programmer prog){
                System.out.println(prog.getIq());
            }else if (employee instanceof Manager man){
                System.out.println(man.toString());
            }else{

            }
            System.out.println(employee.toString());
            totalSalaries += employee.getSalary();

        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));

        WeirdoNew larry = new WeirdoNew("David", "Larry", LocalDate.of(1995, 12, 30));
        //cannot be changed so no need for setters
        System.out.println();
    }

}

