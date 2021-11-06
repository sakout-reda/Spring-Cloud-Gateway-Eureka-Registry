package ord.sid.customer_service;

import ord.sid.customer_service.entities.Customer;
import ord.sid.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "Mohamed", "med@gmail.com"));
            customerRepository.save(new Customer(null, "Hassan", "hassan@gmail.com"));
            customerRepository.save(new Customer(null, "Salima", "salima@gmail.com"));
            customerRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
