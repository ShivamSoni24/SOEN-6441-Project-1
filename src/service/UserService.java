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

    public String addUser(User u) {
        if(userRepo.isExists(u.getId())){
            return null;
        }

        return userRepo.add(u);
    }

    public Tenant getTenant(String id) {
        User u = userRepo.get(id);

        if(u instanceof Tenant){
            return (Tenant) u;
        }

        return null;
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
