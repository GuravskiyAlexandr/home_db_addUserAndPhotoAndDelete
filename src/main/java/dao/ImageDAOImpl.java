package dao;/*
 * Created by Alexsandr        23.05.2018
 */

import entity.Image;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.File;
import java.util.List;

public class ImageDAOImpl implements ImageDAO {
    private final EntityManager em;

    public ImageDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void addImage(Image image) {
        em.getTransaction().begin();
        try {
            em.persist(image);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public boolean remove(Image image) {
        em.getTransaction().begin();
        try {
            em.remove(image);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        return true;
    }
}
