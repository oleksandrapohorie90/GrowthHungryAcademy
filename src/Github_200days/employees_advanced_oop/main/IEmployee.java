package Github_200days.employees_advanced_oop.main;

import java.util.Comparator;

public interface IEmployee extends Comparator<IEmployee> {
    int getSalary();

    int compare(IEmployee o);
}
