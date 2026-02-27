package com.example.multitenant.presitence.repo;

import com.example.multitenant.presitence.entity.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends R2dbcRepository<Product, Long> {

    Mono<Product> findByName(String tenantId);

}
