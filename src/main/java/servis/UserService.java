package servis;

import entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface UserService {
    boolean add(String name, String age, InputStream stream) throws IOException;

    boolean remove(String[] id);

    List<User> getAll();

    User getUser(Long id);


}
