package tqs.marketplace.entities;

public class Seller extends User {
    private String type;

    public Seller(String email, String password){
        super(email, password);
        this.type = "Seller";
    }

    public Seller(String firstName, String lastName, String email, String contact, String password){
        super(firstName, lastName, email, contact, password);
        this.type = "Seller";
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Seller{" + super.toString() +
                "type='" + type + '\'' +
                '}';
    }
}
