package Github_200days.employees_advanced_oop.main;

public class Pilot implements Flyer {

    private int hoursFlown = 0;
    private boolean ifr = false;

    public Pilot(int hoursFlown, boolean ifr){
        this.hoursFlown=hoursFlown;
        this.ifr=ifr;
    }
@Override
public void fly(){
    System.out.println("prepare for take off ");
}

    @Override
    public int getHoursFlown() {
        return hoursFlown;
    }

    @Override
    public void setHoursFlown(int hoursFlown) {
        this.hoursFlown = hoursFlown;
    }

    @Override
    public boolean isIfr() {
        return ifr;
    }

    @Override
    public void setIfr(boolean ifr) {
        this.ifr = ifr;
    }
}
