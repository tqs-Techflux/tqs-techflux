package tqs.marketplace.entities;

import java.util.Arrays;

public class Product {
    private static int counter = 0;
    private final int id;
    private String name;
    private String description;
    private double price;
    private Object picture;
    private Object[] photos;
    private String[] tags;


    public Product(String name, String description, double price){
        this.id = counter;
        this.name = name;
        this.description = description;
        this.price = price;
        counter++;

    }

    public int getId() {
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

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture=" + picture +
                ", photos=" + Arrays.toString(photos) +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
