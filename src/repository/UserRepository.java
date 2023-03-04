package repository;

import domain.user.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepoInterface {
    private List<User> users = new ArrayList<>();

    public boolean isExists(String id) {
        for(User u:users){
            if(u.getId().equals(id)){
                return true;
            }
        }

        return false;
    }

    public String add(User u) {
        users.add(u);
        return u.getId();
    }

    public boolean delete(String id){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }

        return false;
    }

    public User get(String id){
        for(User u:users){
            if(u.getId().equals(id)){
                return u;
            }
        }

        return null;
    }
}
