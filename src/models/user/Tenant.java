package models.user;

import models.property.Property;
import observer.Observer;

public class Tenant extends User implements Observer {

    public Tenant(String name, String email, String phoneNo) {
        super(name, email, phoneNo);
    }

    boolean isRentPaid;

    @Override
    public String toString() {
        return "Tenant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public void update(Property p) {
        System.out.println(p);
    }
}
