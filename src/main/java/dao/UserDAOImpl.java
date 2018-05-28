package dao;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final EntityManager em;

    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void add(User user) {
        em.getTransaction().begin();
        try {
            em.persist(user);


            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    public boolean remove(User user) {
        em.getTransaction().begin();
        try {
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        return true;
    }

    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User getUser(Long id) {
        Query query = em.createQuery("select u from User u  where u.id = :id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }
}
