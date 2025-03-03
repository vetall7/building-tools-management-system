package org.example.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }


    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${tools.url}") String toolsUrl,
            @Value("${building-works.url}") String buildingWorksUrl,
            @Value("${gateway.url}") String hostUrl
    ){
        return builder
                .routes()
                .route("tools", route -> route
                        .host(hostUrl)
                        .and()
                        .path(
                                "/api/tools",
                                "/api/tools/**",
                                "/api/building-works/{genreId}/tools"
                        )
                        .uri(toolsUrl)
                )
                .route("building-works", route -> route
                        .host(hostUrl)
                        .and()
                        .path(
                                "/api/buiding-works",
                                "/api/building-works/{buildingWorkId}"
                        )
                        .uri(buildingWorksUrl)
                )
                .build();
    }
}
