package com.example.Livrarias.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class dataBaseConfiguration {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    //@Bean
		/*public DataSource dataSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setDriverClassName(driver);
			return ds;
					}*/
    @Bean
    public DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setJdbcUrl(url);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10);//max de conexões a liberar
        config.setMinimumIdle(1);//minimo de conexões a liberar
        config.setPoolName("library_db_pool");
        config.setMaxLifetime(600000);//em milisegundos
        config.setConnectionTimeout(100000);
        config.setConnectionTestQuery("select 1");
        return new HikariDataSource(config);
    }
}
