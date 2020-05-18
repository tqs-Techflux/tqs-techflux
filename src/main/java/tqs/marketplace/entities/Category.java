package tqs.marketplace.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {

    private int categoryID;
    private String categoryName;
    private static List<String> categories = new ArrayList<String>(
            Arrays.asList("components",
                          "computers",
                          "mobile devices"));


    public Category(String categoryName){
        this.categoryName = categoryName;
        this.categoryID = categories.indexOf(this.categoryName);
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
