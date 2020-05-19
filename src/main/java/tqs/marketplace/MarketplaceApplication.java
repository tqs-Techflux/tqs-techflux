package tqs.marketplace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tqs.marketplace.entities.Product;
import tqs.marketplace.repositories.ProductRepository;

@SpringBootApplication
public class MarketplaceApplication {

    public static void main(String[] args) { SpringApplication.run(MarketplaceApplication.class); }


}
