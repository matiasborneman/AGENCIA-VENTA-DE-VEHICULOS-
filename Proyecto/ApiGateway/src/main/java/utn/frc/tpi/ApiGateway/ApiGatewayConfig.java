package utn.frc.tpi.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtGrantedAuthoritiesConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder) {
        return builder.routes()
                // Ruteo al Microservicio de Pruebas de manejo
                .route(p -> p.path("/pruebas/**").uri("https://localhost:8081"))
                // Ruteo al Microservicio de Notificaciones
                .route(p -> p.path("/notificaciones/**").uri("https://localhost:8082"))
                .build();
    }
    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
        //http.authorizeHttpRequests(authorize -> authorize
        http.authorizeExchange(exchanges -> exchanges
        // El rol de Empleado puede crear pruebas sobre el microservicio Pruebas
                        .pathMatchers(org.springframework.http.HttpMethod.POST, "/pruebas/crear-prueba")
                        .hasRole("EMPLEADO")
                        .pathMatchers(org.springframework.http.HttpMethod.PUT, "/pruebas/{id}/finalizar-prueba")
                        .hasRole("EMPLEADO")
                        .pathMatchers(org.springframework.http.HttpMethod.POST, "/notificaciones/send-notificaciones")
                        .hasRole("EMPLEADO")
        //POST PARA "VEHICULO", puede enviar Posiciones
                        .pathMatchers(org.springframework.http.HttpMethod.POST, "/pruebas/enviar-posicion")
                        .hasRole("VEHICULO")
        // GET para rol "ADMINISTRADORES", puede ver los Reportes.
                        .pathMatchers(HttpMethod.GET, "/pruebas/reportes/**")
                        .hasRole("ADMIN")
        ).oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
    @Bean
    public ReactiveJwtAuthenticationConverter jwtAuthenticationConverter() {
        var jwtAuthenticationConverter = new ReactiveJwtAuthenticationConverter();
        var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        // Se especifica el nombre del claim a analizar
        grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        // Se agrega este prefijo en la conversión por una convención de Spring
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
        // Se asocia el conversor de Authorities al Bean que convierte el toke JWT a un objeto Authorization
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter( new ReactiveJwtGrantedAuthoritiesConverterAdapter(grantedAuthoritiesConverter));

        return jwtAuthenticationConverter;
    }
}
