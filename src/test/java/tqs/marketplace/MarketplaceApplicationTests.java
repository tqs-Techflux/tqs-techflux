package tqs.marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tqs.marketplace.controllers.ProductController;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class MarketplaceApplicationTests {

    @Autowired
	private ProductController controller;
    
    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
