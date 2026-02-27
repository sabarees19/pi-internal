package com.example.multitenant.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.connection.lookup.AbstractRoutingConnectionFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@Component
public class TenantRoutingConnectionFactory extends AbstractRoutingConnectionFactory {

    private static final String DB_DATA = "postgres";

    public TenantRoutingConnectionFactory() {
        // Initialize with the default connection factory
        ConnectionFactory defaultFactory = createDefaultConnectionFactory();
        Map<String, ConnectionFactory> tenantConnectionFactories = Map.of("default", defaultFactory);
        // Set the target connection factories
        setTargetConnectionFactories(tenantConnectionFactories);
        // Set the default connection factory
        setDefaultTargetConnectionFactory(defaultFactory);
    }

    private ConnectionFactory createDefaultConnectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "localhost")
                .option(PORT, 5432)
                .option(USER, DB_DATA)
                .option(PASSWORD, DB_DATA)
                .option(DATABASE, DB_DATA)
                .build());
    }

    @Override
    @NonNull
    protected Mono<ConnectionFactory> determineTargetConnectionFactory() {
        return Mono.defer(() -> {
            String tenantId = TenantContext.getCurrentTenant();
            return tenantId == null
                    ? Mono.just(createDefaultConnectionFactory())
                    : tenantMono(tenantId).map(this::createTenantConnectionFactory);
        });
    }

    @Override
    @NonNull
    protected Mono<Object> determineCurrentLookupKey() {
        return Mono.empty();
    }

    public ConnectionFactory createTenantConnectionFactory(Tenant tenant) {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, tenant.getDriver())
                .option(HOST, tenant.getDbUrl())
                .option(PORT, tenant.getPort())
                .option(USER, tenant.getDbUsername())
                .option(PASSWORD, tenant.getDbPassword())
                .option(DATABASE, tenant.getDbName())
                .build());
    }

    public Mono<Map<String, Tenant>> getTenantMap() {

        Tenant tenant1 = new Tenant();
        tenant1.setDriver("postgresql");
        tenant1.setDbUrl("localhost");
        tenant1.setPort(5432);
        tenant1.setDbUsername(DB_DATA);
        tenant1.setDbPassword(DB_DATA);
        tenant1.setDbName("tenant1");

        Tenant tenant2 = new Tenant();
        tenant2.setDriver("postgresql");
        tenant2.setDbUrl("localhost");
        tenant2.setPort(5432);
        tenant2.setDbUsername(DB_DATA);
        tenant2.setDbPassword(DB_DATA);
        tenant2.setDbName("tenant2");

        return Mono.just(Map.of(tenant1.getDbName(), tenant1, tenant2.getDbName(), tenant2));
    }

    public Mono<Tenant> tenantMono(String tenantId) {
        return getTenantMap().map(tenantMap -> tenantMap.get(tenantId));
    }


}