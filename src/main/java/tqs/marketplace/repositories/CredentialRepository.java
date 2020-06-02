package tqs.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import tqs.marketplace.entities.Credential;
import tqs.marketplace.entities.User;

public interface CredentialRepository extends CrudRepository<Credential, Long> {
    Credential loadCredentialsByUsername(String username);
    boolean saveCredential(User user, String password);
}
