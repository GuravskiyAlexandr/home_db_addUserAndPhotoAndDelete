package dao;

import entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    boolean remove(User user);
    List<User> getAll();
    User getUser(Long id);
}
