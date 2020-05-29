package tqs.marketplace.entities;

public class Buyer extends User {
    private String type;

    public Buyer(String email, String password){
        super(email, password);
        this.type = "Buyer";
    }

    public Buyer(String firstName, String lastName, String email, String contact, String password){
        super(firstName, lastName, email, contact, password);
        this.type = "Buyer";
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Buyer{" + super.toString() +
                "type='" + type + '\'' +
                '}';
    }
}
