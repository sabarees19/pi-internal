package com.example.multitenant.controller;

import com.example.multitenant.config.Tenant;
import com.example.multitenant.config.TenantContext;
import com.example.multitenant.config.TenantRoutingConnectionFactory;
import com.example.multitenant.presitence.repo.ProductRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/product/")
@Slf4j
public class Controller {

    private final ProductRepository productRepository;
    private final DatabaseClient databaseClient;
    private final TenantRoutingConnectionFactory connectionFactory;

    @GetMapping
    public Mono<ApiGetResponse> products() {
        return productRepository.findAll().collectList().flatMap(products -> {
            ApiGetResponse apiGetResponse = new ApiGetResponse();
            apiGetResponse.setResult(products);
            apiGetResponse.setMessage(TenantContext.getCurrentTenant());
            return Mono.just(apiGetResponse);
        });
    }

    @PostMapping("/create")
    public Mono<ApiResponse> db(@RequestBody Tenant tenant) {
        return initializeDatabaseForTenant(tenant).thenReturn(new ApiResponse());
    }

    public Mono<Void> initializeDatabaseForTenant(Tenant tenant) {
        return createTenantDatabase(tenant)
                .then(initializeSchemaForTenant(tenant));
    }

    private Mono<Void> createTenantDatabase(Tenant tenant) {
        String createDbQuery = "CREATE DATABASE " + tenant.getDbName();
        return databaseClient.sql(createDbQuery).then();
    }

    public Mono<Void> initializeSchemaForTenant(Tenant tenant) {
        ConnectionFactory tenantFactory = connectionFactory.createTenantConnectionFactory(tenant);
        DatabaseClient tenantDatabaseClient = DatabaseClient.builder().connectionFactory(tenantFactory).build();
        CompositeDatabasePopulator compositeDatabasePopulator = new CompositeDatabasePopulator();
        compositeDatabasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("tables/create.sql")));
        return tenantDatabaseClient.inConnection(connection ->
                Mono.from(compositeDatabasePopulator.populate(connection))
        );
    }

}
