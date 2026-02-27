package com.example.multitenant.config;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class TenantWebFilter implements WebFilter {

    private static final String TENANT_ID = "X-Tenant-ID";

    @Override
    @NonNull
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String tenantId = exchange.getRequest().getHeaders().getFirst(TENANT_ID);
        TenantContext.setCurrentTenant(tenantId);
        return chain.filter(exchange)
                .doFinally(signalType -> TenantContext.clear());
    }

}
