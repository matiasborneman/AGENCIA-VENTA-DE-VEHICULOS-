package utn.frc.tpi.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder) {
        return builder.routes()
                // Ruteo al Microservicio de Pruebas
                .route(p -> p.path("/api/pruebas/**").uri("https://localhost:8081/api/"))
                // Ruteo al Microservicio de Notificaciones
                .route(p -> p.path("/api/notificaciones/**").uri("https://localhost:8082/api"))
                .build();
    }
}
