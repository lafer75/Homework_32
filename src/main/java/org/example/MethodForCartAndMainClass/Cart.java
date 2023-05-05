package org.example.MethodForCartAndMainClass;

import org.example.ProductListAndConstructor.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
        System.out.println("Продукт " + product.getName() + " Додано до кошика.");
    }

    public void removeProductById(int id) {
        for (Product product : this.products) {
            if (product.getId() == id) {
                this.products.remove(product);
                System.out.println("Продукт " + product.getName() + " видалено з кошика.");
                return;
            }
        }
        System.out.println("Продукт з таким ID " + id + " не знайдений в кошику.");
    }

    public List<Product> displayCart() {
        if (this.products.isEmpty()) {
            System.out.println("Кошик пустий.");
        } else {
            System.out.println("\nКошик:");
            for (Product product : this.products) {
                System.out.println("- " + product);
            }
        }
        return products;
    }
}

