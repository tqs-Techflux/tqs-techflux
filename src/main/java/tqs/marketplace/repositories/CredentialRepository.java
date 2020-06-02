package tqs.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tqs.marketplace.entities.Credential;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Long> {
    Credential findByUsername(String username);;
}
