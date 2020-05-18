package tqs.marketplace.entities;

public class Seller extends User {
    private String type;

    public Seller(String firstName, String lastName, String email, String contact){
        super(firstName, lastName, email, contact);
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
