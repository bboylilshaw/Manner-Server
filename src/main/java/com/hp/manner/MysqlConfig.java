package com.hp.manner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.Driver;

@Configuration

public class MysqlConfig {
	@Autowired
    private Environment env;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver.class");
		}
		catch(Exception e){
			
		}
	}
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource datasource=null;
		String url=env.getProperty("spring.datasource.url");
		String username=env.getProperty("spring.datasource.username");
		String password=env.getProperty("spring.datasource.password");
		datasource=new DriverManagerDataSource(url,username ,password );
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		return datasource;
	}
	@Bean
	public Connection connection(){
		Connection conn=null;
		try {
			conn=dataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
