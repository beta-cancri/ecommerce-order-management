package Dch.Group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = "Dch.Group")
@EnableMongoRepositories(basePackages = "Dch.Group.repository") // for MongoDB repositories
@EnableR2dbcRepositories(basePackages = "Dch.Group.repository") // for R2DBC repositories
public class ECommerceAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ECommerceAppApplication.class, args);
    }
}



