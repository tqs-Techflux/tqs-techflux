package tqs.marketplace.entities;

public class Buyer extends User {
    private String type;

    public Buyer(String firstName, String lastName, String email, String contact){
        super(firstName, lastName, email, contact);
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
