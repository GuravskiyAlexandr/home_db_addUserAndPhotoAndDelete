package entity;/*
 * Created by Alexsandr        22.05.2018
 */

import javax.persistence.*;
import java.io.File;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 1024000000) // указывае в ручную длину контейнера в таблице.
    private byte[] image;

    @OneToOne(mappedBy = "image")
    private User user;

    public Image(byte[] image) {

        this.image = image;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
