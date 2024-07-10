package Github_200days.employees_advanced_oop.main;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String peopleText = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=3000,yoe=14,iq=100}
                Flinstone1, Fred, 1/1/1900, Programmer, {locpd=5000,yoe=14,iq=100}
                Flinstone2, Fred, 1/1/1900, Programmer, {locpd=9000,yoe=14,iq=100}
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
        //List<IEmployee> employees = new LinkedList<>();//linked list doesnt use arr internally
        List<IEmployee> employees = new ArrayList<>(16);//linked list doesnt use arr internally

        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            employees.add(employee);
        }
        IEmployee myEmp = employees.get(1);
        System.out.println(employees.contains(myEmp));

        IEmployee employee1 = Employee.createEmployee("Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}");
        System.out.println(employees.contains(employee1));

        System.out.println(myEmp.equals(employee1));
        //indexOf, contains, containsAll, remove,

        Collections.sort( employees, Comparator.naturalOrder());
//            if (o1 instanceof Employee emp1 && o2 instanceof Employee emp2) {
//                int lnameResult = emp1.lastName.compareTo(emp2.lastName);
//                return lnameResult != 0 ? lnameResult : Integer.compare(emp1.getSalary(), emp2.getSalary());
//
//
//            }
//            return 0;
        //});
        //an anonymous class - Comparator, replaced by lambda
        employees.sort((o1, o2) -> {
            if (o1 instanceof Employee emp1 && o2 instanceof Employee emp2) {
                int lnameResult = emp1.lastName.compareTo(emp2.lastName);
                return lnameResult != 0 ? lnameResult : Integer.compare(emp1.getSalary(), emp2.getSalary());


            }
            return 0;
        });

//        IEmployee first = employees.get(0);
//        IEmployee second = employees.get(1);
//        IEmployee third = employees.get(2);
//
//        employees.remove(first);
//        employees.remove(1);
//
//
        List<String> undesirables = List.of("Wilma5", "Barney4", "Fred2");//to create a list
        undesirables.sort(Comparator.naturalOrder());
        System.out.println(undesirables);
//        //undesirables.add("Fred");
//        List<String>newStrings = new ArrayList<>();
//        newStrings.addAll(undesirables);//add the whole collection
//
//        removeUndesirablesed(employees, undesirables);

        //enhanced for loop
//        for (IEmployee worker : employees) {
//            if (worker instanceof Employee) {
//                Employee tmpWorker = (Employee) worker;
//                if (undesirables.contains(((Employee) worker).firstName)) {
//                    employees.remove(worker);
//                }
//            }
//            System.out.println(worker.toString());
//            totalSalaries += worker.getSalary();
//        }
//
//
//        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
//        System.out.printf("The total payout should be %s%n", currencyInstance.format(totalSalaries));
//
//        WeirdoNew larry = new WeirdoNew("David", "Larry", LocalDate.of(1995, 12, 30));
//        //cannot be changed so no need for setters
//        System.out.println();
//    }

//    private static void removeUndesirablesed(List<IEmployee> employees, List<String> removalNames) {
//        //if you need to remove items while you are iterating over them
//        //for loop with 2 threads
//        for(Iterator<IEmployee> it = employees.iterator(); it.hasNext();){
//            IEmployee worker = it.next();//give the current element its pointing to
//            if (worker instanceof Employee tmpWorker){//pattern matching
//                if(removalNames.contains(tmpWorker.firstName)){
//                    it.remove();
//                }
//            }
//        }
   }


    }

