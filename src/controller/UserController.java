package controller;

import domain.user.Tenant;
import domain.user.User;
import service.UserService;
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

//    public List<Tenant> listTenant(){
//        return List<Tenant> ();
//    }
}
