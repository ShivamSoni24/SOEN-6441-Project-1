package Main.models.user;

import Main.models.property.Property;
import Main.observer.Observer;

public class Tenant extends User implements Observer {

    public Tenant(String name, String email, String phoneNo) {
        super(name, email, phoneNo);
    }

    boolean isRentPaid;

//    @Override
//    public String toString() {
//        return "Tenant{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNo='" + phoneNo + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Tenant{Tenant ID: " + id +
                "\nname = " + name +
                "\nemail = " + email +
                "\nphoneNo = " + phoneNo +
                "}";
    }

    @Override
    public Tenant update(Property p) {
        return this;
    }
}
