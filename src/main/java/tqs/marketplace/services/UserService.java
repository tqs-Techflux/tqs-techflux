package tqs.marketplace.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.marketplace.entities.User;

@Service
public class UserService {
    private String dbServerUrl = "";

    public ResponseEntity<User> search(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<User> response = template.exchange(this.dbServerUrl, HttpMethod.GET, null, new ParameterizedTypeReference<User>() {});
        System.out.println(response.getBody());
        return response;
    }

    public ResponseEntity<User> search(int id){
        // query db server with productId

        dbServerUrl = "id";

        RestTemplate template = new RestTemplate();
        ResponseEntity<User> response = template.exchange(this.dbServerUrl, HttpMethod.GET, null, new ParameterizedTypeReference<User>() {});
        System.out.println(response.getBody());
        return response;
    }
}
