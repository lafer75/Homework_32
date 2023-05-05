package org.example.Bean;
import org.example.MethodForCartAndMainClass.Cart;
import org.example.ProductListAndConstructor.ProductRepository;
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
