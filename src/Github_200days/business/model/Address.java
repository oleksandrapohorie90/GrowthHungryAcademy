package Github_200days.business.model;

public class Address {
    private String address1;
    private String address2;
    private String city;
    private String state;

    public Address(String address1, String address2, String city, String state) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
    }
    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

   }
