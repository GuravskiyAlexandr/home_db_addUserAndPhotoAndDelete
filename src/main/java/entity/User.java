package entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // fetch = FetchType. ,
    @JoinColumn(name = "image_id")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User(Image image) {

        this.image = image;
    }

    public User() {}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
