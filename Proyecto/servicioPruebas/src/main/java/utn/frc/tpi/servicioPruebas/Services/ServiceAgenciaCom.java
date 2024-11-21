package utn.frc.tpi.servicioPruebas.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import utn.frc.tpi.servicioPruebas.Entities.AgenciaCom.AgenciaCom;

@NoArgsConstructor
@AllArgsConstructor
public class ServiceAgenciaCom {
    private final String baseUrl = "http://labsys.frc.utn.edu.ar/apps-disponibilizadas/backend/api/v1/configuracion";
    WebClient.Builder webClient = WebClient.builder();
    public AgenciaCom agencia() {
        return webClient.baseUrl(baseUrl)
                .build()
                .get()
                .uri("/")
                .retrieve()
                .bodyToMono(AgenciaCom.class)
                .block();
    }
}
