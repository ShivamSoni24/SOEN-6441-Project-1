package service;

import domain.user.Admin;
import domain.user.Tenant;

import java.util.List;

public interface UserSvcInterface {
    String addTenant(Tenant t);
    List<Tenant> getTenants();
    List<Admin> getAdmins();
}
