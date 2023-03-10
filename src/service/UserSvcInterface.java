package service;

import models.user.Admin;
import models.user.Tenant;
import models.user.User;

import java.util.List;

public interface UserSvcInterface {
    String addUser(User u);
    Tenant getTenant(String id);
    List<Tenant> getTenants();
    List<Admin> getAdmins();
}
