package com.gateway.config;



import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> historialRoute() {
        return GatewayRouterFunctions.route("historial")
                .route(GatewayRequestPredicates.path("/api/doctores/**"), HandlerFunctions.http("http://localhost:8092"))
                .route(GatewayRequestPredicates.path("/api/consultas/**"), HandlerFunctions.http("http://localhost:8092"))
                .route(GatewayRequestPredicates.path("/api/historiales/**"), HandlerFunctions.http("http://localhost:8092"))
                .route(GatewayRequestPredicates.path("/api/horario/**"), HandlerFunctions.http("http://localhost:8092"))
                .route(GatewayRequestPredicates.path("/api/pacientes/**"), HandlerFunctions.http("http://localhost:8092"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> citaRoute(){
        return GatewayRouterFunctions.route("citas")
                .route(GatewayRequestPredicates.path("/api/citas/**"),HandlerFunctions.http("http://localhost:8090"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> notificacionRoute(){
        return GatewayRouterFunctions.route("notificaciones")
                .route(GatewayRequestPredicates.path("/api/notificacines/**"),HandlerFunctions.http("http://localhost:8091"))
                .build();
    }
}