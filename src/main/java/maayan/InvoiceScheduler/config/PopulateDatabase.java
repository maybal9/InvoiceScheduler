package maayan.InvoiceScheduler.config;

import maayan.InvoiceScheduler.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopulateDatabase {
    private static final Logger log = LoggerFactory.getLogger(PopulateDatabase.class);

    @Bean
    CommandLineRunner InitDatabase(InvoiceRepository repo){
        // go over all invoices details file and create invoices objects and add them to DB
        return args -> {
            log.info("Preloading...");
        };
    }
}
