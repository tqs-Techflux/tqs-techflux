package tqs.marketplace.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
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
                "969999999",
                "abcdefgh"));
        this.repository.save(new User(
                "Vicente",
                "Correia",
                "vicorreia@gmail.com",
                "966666666",
                "12345678"));
        return true;
    }


    public boolean saveUser(String fName, String lName, String email, String contact, String password) {
        this.repository.save(new User(fName, lName, email, contact, password));
        return true;
    }

    public boolean saveUser(String email, String password) {
        this.repository.save(new User(email, password));
        return true;
    }

    public List<User> findByName(String partialName){
        List<User> retList = new ArrayList<User>();
        retList.addAll((List<User>) repository.findByFirstNameContaining(partialName));
        retList.addAll((List<User>) repository.findByLastNameContaining(partialName));

        return retList;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (User) repository.findByEmail(email);
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        return (User) repository.findByEmail(email);
    }

    public User findById(long id){
        return (User) repository.findById(id);
    }
}
