package Github_200days.employees_advanced_oop.main;

import java.time.LocalDate;


public class Main2 {
    record Programmer (String lastName, String firstName, LocalDate dob, int orgSize, int dr){

//    public static void main(String[] args) {
//        Object employee = new Programmer("Tim","Terry", LocalDate.of(1974,9,23),1000, 25);
//        switch (employee){
//            case null:
//                System.out.println("You supplied nothin");
//                break;
//            case Programmer(var l, var f, var d, var locpd, var yoe, var eq) when
//                locpd <50:
//                System.out.println(STR."\{f} you only write \{locpd} lines per day. You are better! ");
//            break;
//            case Programmer(var l, var f, var d, var locpd, var yoe, var eq) when
//                locpd>=50:
//                System.out.println(STR."\{f} you write a whopping \{locpd} lines per day. Way to go! );
//        }
//
//    }
}
