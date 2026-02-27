package com.pirai.user.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class DBConfig extends AbstractR2dbcConfiguration {

    @Value("${user.dbConfig}")
    private String dbConfig;

    @Value("${spring.r2dbc.url}")
    private String r2dbcUrl;


    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(r2dbcUrl);
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        var databasePopulate = new CompositeDatabasePopulator();
        if(dbConfig.equalsIgnoreCase("create")){
            databasePopulate.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("tables/user.sql")));
        }else if(dbConfig.equalsIgnoreCase("update")) {
            databasePopulate.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("updates/updates.sql")));
        }
        initializer.setDatabasePopulator(databasePopulate);
        return initializer;
    }
}
