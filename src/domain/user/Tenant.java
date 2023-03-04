package domain.user;

public class Tenant extends User {

    public Tenant(String name, String email, String phoneNo) {
        super(name, email, phoneNo);
    }

    boolean isRentPaid;
}
