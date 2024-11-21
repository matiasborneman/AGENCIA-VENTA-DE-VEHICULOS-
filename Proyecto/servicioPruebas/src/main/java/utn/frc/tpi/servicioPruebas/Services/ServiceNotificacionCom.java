package utn.frc.tpi.servicioPruebas.Services;

import lombok.NoArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import utn.frc.tpi.servicioPruebas.Entities.Dto.NotificacionDto;

@NoArgsConstructor
public class ServiceNotificacionCom {
    private final String baseUrl = "http://localhost:8082";
    WebClient.Builder webClient = WebClient.builder();
    public NotificacionDto sendNotificacion(NotificacionDto notificacionBody) {
        return webClient.baseUrl(baseUrl)
                .build()
                .post()
                .uri("/notificacion/enviar-notificacion-exceso/")
                .body(Mono.just(notificacionBody), NotificacionDto.class)
                .retrieve()
                .bodyToMono(NotificacionDto.class)
                .block();
    }
}
