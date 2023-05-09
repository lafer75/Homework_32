package org.example.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductRepository {
    private final List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<Product>();
        productList.add(new Product(1, "Спрайт", 18.5));
        productList.add(new Product(2, "Кока-Кола", 19.0));
        productList.add(new Product(3, "Хліб", 24.9));
        productList.add(new Product(4, "Масло", 36.3));
        productList.add(new Product(5, "Морозиво", 45.0));
    }

    public Product getProductById(int id) {
        for (Product product : this.productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public List<Product> getProduct() {
        return this.productList;
    }
}

