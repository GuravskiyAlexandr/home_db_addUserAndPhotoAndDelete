package servis;

import entity.User;

import java.util.List;

public interface UserService {
    void add(String name, int age, byte[] buffer);

    boolean remove(String[] id);

    List<User> getAll();

    User getUser(Long id);


}
