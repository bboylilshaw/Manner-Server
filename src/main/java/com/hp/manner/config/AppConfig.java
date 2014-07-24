package com.hp.manner.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@Import({ MongodbConfig.class })
@ComponentScan(
    basePackages = "com.hp.manner",
    excludeFilters = @ComponentScan.Filter(
        value = { Repository.class, Controller.class, RestController.class },
        type = FilterType.ANNOTATION
    )
)
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
