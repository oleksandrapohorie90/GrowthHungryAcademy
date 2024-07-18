package Github_200days.employees_advanced_oop.main;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CEO extends Employee implements IEmployee,Apple,Flyer{
    private Flyer flyer = new Pilot(1000,true);

    public CEO(String personText) {
        super(personText);
    }

    @Override
    public int getSalary() {
        return 0;
    }

    public void fly() {
        flyer.fly();
    }

    public int getHoursFlown() {
        return flyer.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        flyer.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return flyer.isIfr();
    }

    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
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
}
