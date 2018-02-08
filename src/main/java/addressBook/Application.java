package addressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "0123456789"));
            repository.save(new BuddyInfo("Chloe", "1234567890"));
            repository.save(new BuddyInfo("Jack", "2345678901"));
            repository.save(new BuddyInfo("David", "3456789012"));
            repository.save(new BuddyInfo("Michelle", "0123456789"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByName('Jack'):");
            log.info("--------------------------------------------");
            for (BuddyInfo bauer : repository.findByName("Jack")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }

}
