package Github_200days.employees_advanced_oop.main;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee{

    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    private final String progRegex = "\\w+=(?<locpd>\\w),\\w+=(?<yoe>\\w),\\w+=(?<iq>\\w)";
    private final Pattern progPat = Pattern.compile(progRegex);
    private final NumberFormat moneyFormat= NumberFormat.getCurrencyInstance();

    public Programmer(String personText) {
        super(personText); //call the constructor from Employee class
            Matcher progMat = progPat.matcher(peopleMat.group("details"));
            if (progMat.find()) {
                this.linesOfCode = Integer.parseInt(progMat.group("locpd"));
                this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
                this.iq = Integer.parseInt(progMat.group("iq"));

            }
        }

    }
    public int getSalary(){
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", lastName,firstName,moneyFormat.format(getSalary()));
    }
}
