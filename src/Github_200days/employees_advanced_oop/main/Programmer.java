package Github_200days.employees_advanced_oop.main;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee implements IEmployee, Apple, Cheff {

    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    private final String progRegex = "\\w+=(?<locpd>\\w),\\w+=(?<yoe>\\w),\\w+=(?<iq>\\w)";
    private final Pattern progPat = Pattern.compile(progRegex);

    public Programmer(String personText) {
        super(personText); //call the constructor from Employee class
        Matcher progMat = progPat.matcher(peopleMat.group("details"));
        if (progMat.find()) {
            this.linesOfCode = Integer.parseInt(progMat.group("locpd"));
            this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
            this.iq = Integer.parseInt(progMat.group("iq"));

        }
    }


    public int getSalary() {
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public int compare(IEmployee o1, IEmployee o2) {
        return 0;
    }

    @Override
    public Comparator<IEmployee> reversed() {
        return super.reversed();
    }

    @Override
    public Comparator<IEmployee> thenComparing(Comparator<? super IEmployee> other) {
        return super.thenComparing(other);
    }

    @Override
    public <U> Comparator<IEmployee> thenComparing(Function<? super IEmployee, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<IEmployee> thenComparing(Function<? super IEmployee, ? extends U> keyExtractor) {
        return super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<IEmployee> thenComparingInt(ToIntFunction<? super IEmployee> keyExtractor) {
        return super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<IEmployee> thenComparingLong(ToLongFunction<? super IEmployee> keyExtractor) {
        return super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<IEmployee> thenComparingDouble(ToDoubleFunction<? super IEmployee> keyExtractor) {
        return super.thenComparingDouble(keyExtractor);
    }

    @Override
    public void cook(String food) {
        Cheff.super.cook(food);
    }

    @Override
    public String cleanUp() {
        return Cheff.super.cleanUp();
    }
}
