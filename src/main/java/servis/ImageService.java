package servis;/*
 * Created by Alexsandr        23.05.2018
 */

import entity.Image;

import java.util.List;

public interface ImageService {

    void addaImage(Image image);
    boolean remove(Image  image);

}
