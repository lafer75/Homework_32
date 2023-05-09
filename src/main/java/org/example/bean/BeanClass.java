package org.example.bean;
import org.example.main.Cart;
import org.example.product.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClass {

    @Bean
    public Cart getCart() {
        return new Cart();
    }

    @Bean
    public ProductRepository getProductRepository() {
        return new ProductRepository();
    }
}
