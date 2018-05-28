package servis;/*
 * Created by Alexsandr        23.05.2018
 */

import entity.Image;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImageServiceImpl implements ImageService {
    private final EntityManager em;

    public ImageServiceImpl(EntityManager em) {
        this.em = em;
    }

    public void addaImage(Image image) {
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
