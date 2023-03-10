package repository;

import models.user.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements UserRepoInterface {
    private final Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public boolean isExists(String id) {
        return users.containsKey(id);
    }

    public String add(User u) {
        users.put(u.getId(), u.clone());

        return u.getId();
    }

    public boolean delete(String id){
        User u = users.remove(id);

        return u!=null;
    }

    public User get(String id){
        return users.get(id);
    }

    public List<User> getAll(){
        return new ArrayList<>(users.values());
    }
}
