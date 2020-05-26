package tqs.marketplace.services;


import org.springframework.stereotype.Service;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
        this.saveUsers();
    }

    public boolean saveUsers() {
        // save a few users
        this.repository.save(new User("João", "Azambuja", "joaoaz@gmail.com", "969999999"));
        this.repository.save(new User("Vicente", "Correia", "vicorreia@gmail.com", "966666666"));
        return true;
    }

    public boolean saveUser(String fName, String lName, String email, String contact) {
        // save a few products
        this.repository.save(new User(fName, lName, email, contact));
        return true;
    }


    public List<User> findByName(String partialName){
        List<User> retList = new ArrayList<User>();

        // fetch a list of users by partialName in firstName
        for (User user : repository.findByFirstNameContaining(partialName)) {
            retList.add(user);
            System.out.println(user.toString());
        }
        // fetch a list of users by partialName in lastName
        for (User user : repository.findByLastNameContaining(partialName)) {
            retList.add(user);
            System.out.println(user.toString());
        }

        return retList;
    }

    public User findByEmail(String email){
        User user = repository.findByEmail(email);
        System.out.println(user.toString());
        return user;
    }

    public User findById(long id){
        // fetch an individual user by ID
        User user = repository.findById(id);
        System.out.println(user.toString());
        return user;
    }
}
