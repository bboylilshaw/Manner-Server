package com.hp.manner;

import com.hp.manner.security.UserRepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.header.HeaderWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "manner";

    @Autowired
    private UserRepositoryUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        return new TokenBasedRememberMeServices(KEY, userDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
//            .headers().disable()
            .authorizeRequests()
                .antMatchers("/api/**","/rest/**").permitAll()
                .anyRequest().permitAll();
        http.headers().addHeaderWriter(new HeaderWriter() {
            @Override
            public void writeHeaders(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
                httpServletResponse.setHeader("Content-Type","application/json");
                httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
                httpServletResponse.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
                httpServletResponse.setHeader("Access-Control-Max-Age","60");
            }
        });

    }

}
