package domain.user;

public class Admin extends User{
    public Admin(String name, String email, String phoneNo) {
        super(name, email, phoneNo);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
