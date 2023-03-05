package service;

import domain.user.Admin;
import domain.user.Tenant;
import domain.user.User;

import java.util.List;

public interface UserSvcInterface {
    String addUser(User u);
    List<Tenant> getTenants();
    List<Admin> getAdmins();
}
