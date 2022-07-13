package com.gate.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
       return builder.routes()
      .route("userId", r->r.path("/user/**").uri("http://localhost:5561")) //static routing
      .route("orderId", r->r.path("/order/**").uri("http://localhost:8085"))
      .route("productId",r->r.path("/product/**").uri("http://localhost:5562"))
      .route("inventoryId",r->r.path("/inventory/**").uri("http://localhost:5563"))
      .route("cartId",r->r.path("/cart/**").uri("http://localhost:5565"))
      .build();
    }
}
