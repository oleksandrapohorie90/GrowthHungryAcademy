package Github_200days.employees_advanced_oop.main;

public class CEO extends Employee{
    public CEO(String personText) {
        super(personText);
    }

    @Override
    public int getSalary() {
        return 0;
    }
}
