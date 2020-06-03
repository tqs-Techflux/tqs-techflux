package tqs.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private CredentialService cs;

    public void saveUsers() {
        // save a few users
        saveUser("João",
                "Azambuja",
                "joaoaz@gmail.com",
                "969999999",
                "abcdefgh"
        );
        saveUser(
                "Vicente",
                "Correia",
                "vicorreia@gmail.com",
                "966666666",
                "12345678"
        );
        saveUser(
                "Tomás",
                "Esteves",
                "testeves@gmail.com",
                "928888888",
                "123123123"
        );

    }

    public boolean saveUser(String fName, String lName, String email, String contact, String password) {
        User u = new User(fName, lName, email, contact);
        this.repository.save(u);

        boolean b = this.cs.saveCredential(email, password);
        return b;
    }

    public boolean updateUser(String username, String fName, String lName, String email, String contact) {
        User user = this.repository.findByEmail(username);

        if (fName != null)
            user.setFirstName(fName);
        if (lName != null)
            user.setLastName(lName);
        if (email != null)
            user.setEmail(email);
            this.cs.updateCredential(username, email, null);
        if (contact != null)
            user.setContact(contact);
        this.repository.save(user);
        return true;
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        return (User) repository.findByEmail(email);
    }

    public List<User> findByName(String partialName){
        List<User> retList = new ArrayList<User>();
        retList.addAll((List<User>) repository.findByFirstNameContaining(partialName));
        retList.addAll((List<User>) repository.findByLastNameContaining(partialName));
        return retList;
    }

    public User findById(long id){
        return (User) this.repository.findById(id);
    }
}
