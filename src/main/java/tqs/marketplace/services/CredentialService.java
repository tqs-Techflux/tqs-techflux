package tqs.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Credential;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.CredentialRepository;

@Service
public class CredentialService implements UserDetailsService {

    @Autowired
    private CredentialRepository repository;
    @Autowired
    private UserService us;

    protected CredentialService(){}

    public CredentialService(CredentialRepository repository){
        this.repository = repository;
        this.saveCredentials();
    }

    public boolean saveCredentials() {
        this.us.saveUsers();

        // save a few credentials
        User u1 = this.us.loadUserByEmail("joaoaz@gmail.com");
        User u2 = this.us.loadUserByEmail("vicorreia@gmail.com");
        User u3 = this.us.loadUserByEmail("testeves@gmail.com");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);

        this.repository.save(new Credential(u1, "abcdefgh"));
        this.repository.save(new Credential(u2, "12345678"));
        this.repository.save(new Credential(u3, "123123123"));
        return true;
    }

    public boolean saveCredential(String username, String password) {
        User user = this.us.loadUserByEmail(username);
        this.repository.save(new Credential(user, password));
        return true;
    }

    public boolean updateCredential(String username, String newUsername, String newPassword){
        Credential user = this.repository.findByUsername(username);
        if (newUsername != null)
            user.setUsername(newUsername);
        if (newPassword != null)
            user.setPassword(newPassword);
        this.repository.save(user);
        return true;
    }

    public UserDetails loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        return (Credential) repository.findByUsername(username);
    }

    public Credential loadUserByUsername(String username) throws UsernameNotFoundException {
        return (Credential) repository.findByUsername(username);
    }

}
