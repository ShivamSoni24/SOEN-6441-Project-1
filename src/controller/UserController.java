package controller;

import domain.user.Admin;
import domain.user.Tenant;
import service.UserSvcInterface;

import java.util.List;

public class UserController {

    private UserSvcInterface userSvc;

    public UserController(UserSvcInterface userSvc) {
        this.userSvc = userSvc;
    }

    public String addTenant(String name, String email, String phone){
        Tenant t = new Tenant(name, email, phone);
        return userSvc.addUser(t);
    }

    public String addAdmin(String name, String email, String phone){
        Admin a = new Admin(name, email, phone);
        return userSvc.addUser(a);
    }

    public List<Tenant> getTenants(){
        return userSvc.getTenants();
    }

    public List<Admin> getAdmins() {
        return userSvc.getAdmins();
    }
}
