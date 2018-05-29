package servis;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.Image;
import entity.User;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final EntityManager em;

    public UserServiceImpl(EntityManager em) {
        this.em = em;
    }

    public boolean add(String name, String age, InputStream stream) throws IOException {
        if (!name.equals("") & !age.equals("")) {
            InputStream st = stream;
            byte[] buffer = new byte[st.available()];
            st.read(buffer, 0, st.available());

            int iAge = Integer.parseInt(age);

            if (name.length() > 2 && iAge > 5) {
                User user = new User(name, iAge);
                Image image = new Image(buffer);
                user.setImage(image);
                ImageDAO imageDAO = new ImageDAOImpl(em);
                UserDAO userDAO = new UserDAOImpl(em);
                imageDAO.addImage(image);
                userDAO.add(user);
                return true;
            }
        }
        return false;
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
