package Github_200days.employees_advanced_oop.main;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee {

    private int orgSize = 0;
    private int directReports = 0;

    private final String mngrRegex = "\\w+\\=(?<orgSize>\\w+)\\,\\w+\\=(?<dr>\\w+)";
    private final Pattern mngrPat = Pattern.compile(mngrRegex);

    public Manager(String personText) {
        super(personText);
        Matcher mgrMat = mngrPat.matcher(peopleMat.group("details"));
        if (mgrMat.find()) {
            this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            this.directReports = Integer.parseInt(mgrMat.group("dr"));
        }
    }

public int getSalary() {
    return 3500 + orgSize * directReports;
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
