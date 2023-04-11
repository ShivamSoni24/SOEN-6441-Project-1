package Main.models.property;

import Main.models.user.Tenant;
import Main.observer.Observer;
import Main.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class Property implements Cloneable, Subject {
    private static int counter = 0;

    private final List<Observer> interestedTenants;
    String id;
    String streetName;
    String city;
    String postalCode;
    String province;
    String country;
    boolean isOccupied;

    public Property(String streetName, String city, String postalCode, String province, String country) {
        this.id = String.valueOf(++counter);
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
        this.isOccupied = false;
        this.interestedTenants = new ArrayList<>();
    }
    public String getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public Property clone() {
        try {
            return (Property) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void addListener(Observer o) {
        if(!interestedTenants.contains(o)){
            interestedTenants.add(o);
        }
    }

    @Override
    public void removeListener(Observer o) {
        interestedTenants.remove(o);
    }

    @Override
    public List<Tenant> notifyListeners() {
        List<Tenant> tenants = new ArrayList<>();

        for(Observer o:interestedTenants){
            tenants.add(o.update(this));
        }

        return tenants;
    }
}

