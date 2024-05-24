package Github_200days.employees_advanced_oop.main;

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
}
