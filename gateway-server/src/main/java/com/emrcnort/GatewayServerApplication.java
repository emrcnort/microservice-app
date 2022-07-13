package com.emrcnort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class,args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //@formatter:off
        return builder.routes()
                .route("account-service", r -> r.path("/account/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("circuitBreaker").setFallbackUri("forward:/fb/account")).rewritePath("/account/(?<segment>.*)", "/account/${segment}"))
                        .uri("lb://ACCOUNT-SERVICE"))
                .route("ticket-service", r -> r.path("/ticket/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("circuitBreaker").setFallbackUri("forward:/fb/ticket")).rewritePath("/ticket/(?<segment>.*)", "/ticket/${segment}"))
                        .uri("lb://TICKET-SERVICE"))
                .build();
        //@formatter:on
    }


}
