package service;

import domain.user.Tenant;
import repository.UserRepoInterface;
import repository.UserRepository;

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

}
