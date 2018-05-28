package dao;/*
 * Created by Alexsandr        23.05.2018
 */

import entity.Image;
import java.util.List;

public interface ImageDAO {
    void addImage(Image image);
    boolean remove(Image  image);

}
