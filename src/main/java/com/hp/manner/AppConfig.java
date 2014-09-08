package com.hp.manner;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({ WebSecurityConfig.class, MongodbConfig.class })
@ComponentScan(
    basePackages = "com.hp.manner",
    excludeFilters = @ComponentScan.Filter(
        value = { Configuration.class, Controller.class, RestController.class },
        type = FilterType.ANNOTATION
    )
)
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
