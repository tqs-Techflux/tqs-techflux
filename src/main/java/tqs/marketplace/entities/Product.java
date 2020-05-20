package tqs.marketplace.entities;

import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    private String picturePath;
    //private Object[] photos;
    //private String[] tags;

    protected Product(){}

    // without picturePath
    public Product(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // with picturePath
    public Product(String name, String description, double price, String picturePath){
        this.name = name;
        this.description = description;
        this.price = price;
        this.picturePath = picturePath;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePathicture(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picturePath=" + picturePath +
         //       ", photos=" + Arrays.toString(photos) +
         //       ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
