package tqs.marketplace.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tqs.marketplace.entities.Credential;
import tqs.marketplace.repositories.CredentialRepository;

import static org.junit.jupiter.api.Assertions.*;

class CredentialServiceTest {


    @MockBean
    private CredentialRepository repository;
    @MockBean
    private CredentialService service;

    @BeforeEach
    void setUp(){
        this.service = new CredentialService();
    }


    @Test
    void saveCredentialTest() {
        String testUser = "test";
        String testPass = "test";
        service.saveCredential(testUser,testPass);
        assertEquals(testUser, service.loadUserByUsername(testUser).getUsername());

    }

    @Test
    void updateCredentialUsernameTest() {
        String testUser = "test";
        String testPass = "test";
        service.saveCredential(testUser,testPass);
        service.updateCredential(testUser, "test2", "");
        assertEquals("test2", service.loadUserByUsername("test2").getUsername());
    }

    @Test
    void updateCredentialPasswordTest() {
        String testUser = "test";
        String testPass = "test";
        service.saveCredential(testUser,testPass);
        service.updateCredential(testUser, "", "test2");
        assertEquals("test2", service.loadUserByUsername("test").getPassword());
    }

    @Test
    void updateCredentialUsernameAndPasswordTest() {
        String testUser = "test";
        String testPass = "test";
        service.saveCredential(testUser,testPass);
        service.updateCredential(testUser, "test2", "test2");
        assertEquals("test2", service.loadUserByUsername("test2").getPassword());
        assertEquals("test2", service.loadUserByUsername("test2").getUsername());
    }



}