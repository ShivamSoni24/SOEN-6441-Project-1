package Main.models.user;

public class Admin extends User{
    public Admin(String name, String email, String phoneNo) {
        super(name, email, phoneNo);
    }

//    @Override
//    public String toString() {
//        return "Admin{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNo='" + phoneNo + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Admin{\nAdmin ID: " + id + '\'' +
                "\nname = " + name +
                "\nemail = " + email +
                "\nphoneNo = " + phoneNo +
                "}";
    }
}
