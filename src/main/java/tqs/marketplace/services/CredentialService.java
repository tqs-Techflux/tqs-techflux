package tqs.marketplace.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Credential;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.CredentialRepository;

@Service
public class CredentialService implements UserDetailsService {
    private CredentialRepository repository;

    protected CredentialService(){}

    public CredentialService(CredentialRepository repository){
        this.repository = repository;
        this.saveCredentials();
    }

    public boolean saveCredentials() {
        // save a few credentials
        UserService userService = new UserService();
        User u1 = userService.findById(0);
        User u2 = userService.findById(1);
        User u3 = userService.findById(2);

        this.repository.save(new Credential(u1, "abcdefgh"));
        this.repository.save(new Credential(u2, "12345678"));
        this.repository.save(new Credential(u3, "123123123"));
        return true;
    }

    public boolean saveCredential(long userId, String password) {
        User user = new UserService().findById(userId);
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
