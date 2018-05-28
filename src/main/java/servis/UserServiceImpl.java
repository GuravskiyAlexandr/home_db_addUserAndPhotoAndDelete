package servis;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.Image;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final EntityManager em;

    public UserServiceImpl(EntityManager em) {
        this.em = em;
    }

    public void add(String name, int age, byte[] bytes) {
        if (name.length() > 2 && age > 5) {
            User user = new User(name, age);
            Image image = new Image(bytes);
            user.setImage(image);
            ImageDAO imageDAO = new ImageDAOImpl(em);
            UserDAO userDAO = new UserDAOImpl(em);
            imageDAO.addImage(image);
            userDAO.add(user);
        }
    }

    public boolean remove(String[] id) {
        if (id.length > 0) {
            UserDAO dao = new UserDAOImpl(em);
            ImageDAO imageDAO = new ImageDAOImpl(em);
            for (int i = 0; i < id.length; i++) {
                User user = dao.getUser(Long.valueOf(id[i]));
                imageDAO.remove(user.getImage());
                dao.remove(user);
            }
            return true;
        }
        return false;
    }

    public List<User> getAll() {
        UserDAO dao = new UserDAOImpl(em);
        return dao.getAll();
    }

    public User getUser(Long id) {
        if (id > 0) {
            UserDAO dao = new UserDAOImpl(em);
            return dao.getUser(id);
        }
        return null;
    }
}
