package utn.frc.tpi.servicioPruebas;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicioPruebasConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Servicio de Pruebas API")
                        .description("Microservicio API REST de Pruebas para el TPI")
                        .version("1.0"));
    }
}
