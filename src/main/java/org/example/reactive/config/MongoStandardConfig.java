package org.example.reactive.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static org.example.reactive.constant.ProjectConstants.BASE_PACKAGES;

@Configuration
@EnableMongoRepositories(basePackages = BASE_PACKAGES)
@Profile("Standard")
public class MongoStandardConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.username}")
    public String username;

    @Value("${spring.data.mongodb.password}")
    public String password;

    @Value("${spring.data.mongodb.host}")
    public String hostName;

    @Value("${spring.data.mongodb.port}")
    public String port;

    @Value("${spring.data.mongodb.database}")
    public String dbName;

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory databaseFactory){
        return new MongoTransactionManager(databaseFactory);
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://" + username + ":" + password + "@" + hostName + ":" + port + "/" + dbName);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
