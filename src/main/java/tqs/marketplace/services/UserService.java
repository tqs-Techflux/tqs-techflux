package tqs.marketplace.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Credential;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    protected UserService(){}

    public UserService(UserRepository repository){
        this.repository = repository;
        this.saveUsers();
    }

    public boolean saveUsers() {
        // save a few users
        this.repository.save(new User(
                "João",
                "Azambuja",
                "joaoaz@gmail.com",
                "969999999"
        ));
        this.repository.save(new User(
                "Vicente",
                "Correia",
                "vicorreia@gmail.com",
                "966666666"
        ));
        this.repository.save(new User(
                "Tomás",
                "Esteves",
                "testeves@gmail.com",
                "928888888"
        ));
        return true;
    }


    public boolean saveUser(String fName, String lName, String email, String contact, String password) {
        User u = new User(fName, lName, email, contact);
        this.repository.save(u);

        CredentialService credentialservice = new CredentialService();
        credentialservice.saveCredential(u.getId(), password);
        return true;
    }

    public boolean updateUser(String username, String fName, String lName, String email, String contact) {
        User user = this.repository.findByEmail(username);
        CredentialService credentialservice = new CredentialService();

        if (fName != null)
            user.setFirstName(fName);
        if (lName != null)
            user.setLastName(lName);
        if (email != null)
            user.setEmail(email);
            credentialservice.updateCredential(username, email, null);
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
        return (User) repository.findById(id);
    }
}
