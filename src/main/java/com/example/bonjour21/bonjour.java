package com.example.bonjour21;

import com.example.bonjour21.entity.Product;
import com.example.bonjour21.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class bonjour {
    @Bean
    public CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            System.out.println("Inserting sample products...");

            // Using the constructor we defined in the Product class
            repository.save(new Product("Laptop", 999.99, "Electronics"));
            repository.save(new Product("Milk", 2.50, "Groceries"));
            repository.save(new Product("T-Shirt", 19.99, "Apparel"));

            System.out.println("Sample data inserted.");
        };
    }
}