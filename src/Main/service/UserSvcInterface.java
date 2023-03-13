package Main.service;

import Main.models.user.Admin;
import Main.models.user.Tenant;
import Main.models.user.User;

import java.util.List;

public interface UserSvcInterface {
    String addUser(User u);
    Tenant getTenant(String id);
    List<Tenant> getTenants();
    List<Admin> getAdmins();
}
