package service;

import domain.user.*;
import repository.UserRepoInterface;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserSvcInterface{

    private UserRepoInterface userRepo;
    public UserService(UserRepoInterface userRepo) {
        this.userRepo = userRepo;
    }

    public String addTenant(Tenant t) {
        if(userRepo.isExists(t.getId())){
            return null;
        }

        return userRepo.add(t);
    }

    public List<Tenant> getTenants(){
        List<Tenant> tenantList = new ArrayList<>();

        for(User u:userRepo.getAll()){
            if(u instanceof Tenant){
                tenantList.add((Tenant) u);
            }
        }

        return tenantList;
    }

    public List<Admin> getAdmins(){
        List<Admin> adminList = new ArrayList<>();

        for(User u:userRepo.getAll()){
            if(u instanceof Admin){
                adminList.add((Admin) u);
            }
        }

        return adminList;
    }
}
