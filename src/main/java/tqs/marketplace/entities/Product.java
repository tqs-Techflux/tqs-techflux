package tqs.marketplace.entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    private String picture;

    @ManyToOne
    private User owner;
    @ManyToOne
    private Category category;
    //private Object[] photos;
    //private String[] tags;

    protected Product(){}

    // with picturePath
    public Product(String name, String description, double price, String picture){
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture=" + picture +
                ", owner=" + owner +
                ", category=" + category +
         //       ", photos=" + Arrays.toString(photos) +
         //       ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
