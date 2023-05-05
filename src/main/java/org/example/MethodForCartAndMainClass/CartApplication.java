package org.example.MethodForCartAndMainClass;
import java.util.List;
import java.util.Scanner;

import org.example.Bean.BeanClass;
import org.example.ProductListAndConstructor.Product;
import org.example.ProductListAndConstructor.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BeanClass.class)
public class CartApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cart cart;

    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }

    @Override
    public void run(String... args){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("q")) {
            System.out.println("\n-----------------------------------------");
            System.out.println("Введіть '1' щоб додати продукт до кошика");
            System.out.println("Введіть '2' щоб видалити предмет з кошика");
            System.out.println("Введіть '3' щоб подивитися що в кошику");
            System.out.println("Введіть '4' щоб вийти");
            System.out.println("-----------------------------------------");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    List<Product> allProducts = productRepository.getProduct();
                    for (Product product : allProducts) {
                        System.out.println(product);
                    }
                    System.out.println("\nВведіть ID продукта щоб додати його до кошика:");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    Product productToAdd = productRepository.getProductById(productId);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                    }
                    break;
                case "2":
                    System.out.println("\nВведіть ID продукта щоб видалити його з кошика:");
                    productId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    Product productToRemove = productRepository.getProductById(productId);
                    if (productToRemove != null) {
                        cart.removeProductById(productToRemove.getId());
                    }
                    break;
                case "3":
                         cart.displayCart();
                    break;

                case "4":
                    System.exit(0);
                default:
                    System.out.println("\nВи ввели невідомий знак для программи!");
            }
        }
    }
}

