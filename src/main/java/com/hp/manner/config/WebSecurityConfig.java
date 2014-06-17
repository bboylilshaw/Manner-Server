package com.hp.manner.config;

import com.hp.manner.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    //@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
            .inMemoryAuthentication()
                .withUser("jason").password("123456").roles("USER")
                .and()
                .withUser("admin").password("123456").roles("ADMIN");*/
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().disable()
            .authorizeRequests()
                .antMatchers("/resources/**", "/signup").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/api/**").permitAll() //FIXME: add authentication for restful ws call
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home")
                .and()
            .logout()
                .permitAll();
    }

}
