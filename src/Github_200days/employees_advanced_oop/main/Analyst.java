package Github_200days.employees_advanced_oop.main;

public class Analyst extends Employee{
    private int projectCount=0;

    public Analyst(String personText) {
        super(personText);
    }

    @Override
    public int getSalary() {
        return 0;
    }

    @Override
    public int compare(IEmployee o1, IEmployee o2) {
        return 0;
    }
}
