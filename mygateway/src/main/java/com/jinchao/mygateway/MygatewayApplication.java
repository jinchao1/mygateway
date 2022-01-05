package com.jinchao.mygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
@EnableDiscoveryClient
public class MygatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MygatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder locatorBuilder){

        return locatorBuilder.routes()
                .route(p ->
                        p.path("/xxoo")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://mashibing.com")
                        )
                .route(p ->
                        p.path("/go")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://MDB")
                        )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){

        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/003")
                , req -> ServerResponse.ok().body(BodyInserters.fromValue("xxoo"))
        );
        return route;
    }
}






















