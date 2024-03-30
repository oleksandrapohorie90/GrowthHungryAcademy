import specific.animals.Dog;
import model.Person;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        /*when I create a person i want to specify fn,ln,dob*/
        Person tom = new Person("Tom","Smith", LocalDate.of(1984,6,15));
        Person janet = new Person("Janet","Jackson", LocalDate.of(1985,12,15));
        //I want to set tom's spouse to janet
        tom.setSpouse(janet);

        Dog fido = new Dog("Fido",LocalDate.of(2018,1,1));
        tom.setPet(fido);
        System.out.println(tom);


        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);

        }
    }
}