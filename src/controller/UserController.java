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
        return userSvc.addTenant(new Tenant(name, email, phone));
    }

    public List<Tenant> getTenants(){
        return userSvc.getTenants();
    }

    public List<Admin> getAdmins() {
        return userSvc.getAdmins();
    }
}
