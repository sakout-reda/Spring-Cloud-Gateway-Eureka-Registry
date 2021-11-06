package org.ssid.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.ssid.inventoryservice.entity.Product;
import org.ssid.inventoryservice.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null,"Ordinateur",788,12));
            productRepository.save(new Product(null,"Imprimante",88,129));
            productRepository.save(new Product(null,"Smartphone",1288,112));
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}
