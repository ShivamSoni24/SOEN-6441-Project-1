package Main.repository;

import Main.models.user.User;

import java.util.List;

public interface UserRepoInterface {
    boolean isExists(String id);
    String add(User p);
    boolean delete(String id);
    User get(String id);
    List<User> getAll();
}
