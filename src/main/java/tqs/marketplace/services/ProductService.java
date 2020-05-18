package tqs.marketplace.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.marketplace.entities.Product;

@Service
public class ProductService {
    private String dbServerUrl = "";

    public ResponseEntity<Product> search(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<Product> response = template.exchange(this.dbServerUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {
        });
        System.out.println(response.getBody());
        return response;
    }

    public ResponseEntity<Product> search(int id){
        // query db server with productId

        dbServerUrl = "id";

        RestTemplate template = new RestTemplate();
        ResponseEntity<Product> response = template.exchange(this.dbServerUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {
        });
        System.out.println(response.getBody());
        return response;
    }
}
