package com.hp.manner;

import com.hp.manner.common.EmailAuditor;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.hp.manner.repository")
@PropertySource("classpath:mongodb.properties")
public class MongodbConfig {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private Integer port;

    @Value("${mongodb.dbname}")
    private String dbname;

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new MongoClient(host, port), dbname);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public EmailAuditor emailAuditor() {
        return new EmailAuditor();
    }

}
