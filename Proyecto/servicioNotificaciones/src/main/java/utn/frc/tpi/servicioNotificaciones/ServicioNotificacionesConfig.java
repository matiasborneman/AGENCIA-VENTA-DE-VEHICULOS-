package utn.frc.tpi.servicioNotificaciones;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicioNotificacionesConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Servicio de Notificaciones API")
                        .description("Microservicio API REST de NOtificaciones para el TPI")
                        .version("1.0"));
    }
}
