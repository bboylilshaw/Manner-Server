package com.hp.manner.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(basePackages = "com.hp.manner.repository")
@PropertySource("classpath:mongodb.properties")
public class MongodbConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new MongoClient(env.getProperty("mongodb.host"),
                Integer.parseInt(env.getProperty("mongodb.port"))),
                env.getProperty("mongodb.dbname"));
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }

//    @Bean
//    public MongoTypeMapper mongoTypeMapper() {
//        return new DefaultMongoTypeMapper(null);
//    }
//
//    @Bean
//    public MongoMappingContext mongoMappingContext() {
//        return new MongoMappingContext();
//    }
//
//    @Bean
//    public MappingMongoConverter mongoConverter() throws UnknownHostException {
//        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), mongoMappingContext());
//        converter.setTypeMapper(mongoTypeMapper());
//        return converter;
//    }

}
