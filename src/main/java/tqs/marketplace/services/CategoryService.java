package tqs.marketplace.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.marketplace.entities.Category;

@Service
public class CategoryService {
    private String dbServerUrl = "";

    public ResponseEntity<Category> search(int id){
        // query db server with productId

        dbServerUrl = "id";

        RestTemplate template = new RestTemplate();
        ResponseEntity<Category> response = template.exchange(this.dbServerUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Category>() {});
        System.out.println(response.getBody());
        return response;
    }
}
