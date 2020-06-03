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
    }

    public boolean saveCredential(String username, String password) {
        User user = this.us.loadUserByEmail(username);
        this.repository.save(new Credential(user, password));
        return true;
    }

    public Credential updateCredential(String username, String newUsername, String newPassword){
        Credential user = this.repository.findByUsername(username);
        if (newUsername != null)
            user.setUsername(newUsername);
        if (newPassword != null)
            user.setPassword(newPassword);
        this.repository.save(user);
        return user;
    }

    public UserDetails loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        return (Credential) repository.findByUsername(username);
    }

    public Credential loadUserByUsername(String username) throws UsernameNotFoundException {
        return (Credential) repository.findByUsername(username);
    }

}
