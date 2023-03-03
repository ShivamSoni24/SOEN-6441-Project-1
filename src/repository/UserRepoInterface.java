package repository;

import domain.user.User;

import java.util.List;

public interface UserRepoInterface {
    boolean isExists(String id);
    void add(User p);
    boolean delete(String id);
    User get(String id);
}
