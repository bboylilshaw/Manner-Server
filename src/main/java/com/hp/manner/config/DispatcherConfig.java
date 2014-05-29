package com.hp.manner.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"com.hp.manner.controller"},
        includeFilters = @ComponentScan.Filter(
                value = Controller.class,
                type = FilterType.ANNOTATION
        )
)
public class DispatcherConfig {
}
