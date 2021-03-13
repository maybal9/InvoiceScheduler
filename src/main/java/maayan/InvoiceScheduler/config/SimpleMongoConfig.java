package maayan.InvoiceScheduler.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "maayan.InvoiceScheduler")
public class SimpleMongoConfig {

    @Bean
    public MongoClient mongo() {
        //move to application.properties
        String username = "SpringB";
        String pass = "enter951";
        String connection_string = "mongodb+srv://"+username+":"+pass+"@cluster0.kmmgn.mongodb.net/invoices?retryWrites=true&w=majority";

        ConnectionString connectionString = new ConnectionString(connection_string);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "invoices");
    }
}
