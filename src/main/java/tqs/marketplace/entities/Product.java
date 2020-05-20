package tqs.marketplace.entities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    private String picturePath;
    @Lob
    private byte[] picBytes;
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
        this.picBytes = new byte[ (int) new File(this.picturePath).length() ];
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

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public byte[] getPicBytes() {
        return picBytes;
    }

    public void setPicBytes(byte[] picBytes) {
        this.picBytes = picBytes;
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
