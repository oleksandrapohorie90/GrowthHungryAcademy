package Github_200days.employees_advanced_oop.main;

public class Pilot {

    private int hoursFlown = 0;
    private boolean ifr = false;

    public Pilot(int hoursFlown, boolean ifr){
        this.hoursFlown=hoursFlown;
        this.ifr=ifr;
    }
public void fly(){
    System.out.println("prepare for take off ");
}

    public int getHoursFlown() {
        return hoursFlown;
    }

    public void setHoursFlown(int hoursFlown) {
        this.hoursFlown = hoursFlown;
    }

    public boolean isIfr() {
        return ifr;
    }

    public void setIfr(boolean ifr) {
        this.ifr = ifr;
    }
}
