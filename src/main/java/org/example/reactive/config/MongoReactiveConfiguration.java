package org.example.reactive.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static org.example.reactive.constant.ProjectConstants.BASE_PACKAGES;

@Configuration
@EnableMongoRepositories(basePackages = BASE_PACKAGES)
@Profile("Reactive")
public class MongoReactiveConfiguration extends AbstractReactiveMongoConfiguration {

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

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient reactiveMongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://" + username + ":" + password + "@" + hostName + ":" + port + "/" + dbName);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
