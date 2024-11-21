package utn.frc.tpi.servicioNotificaciones.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDto {
    @Schema(description = "Identificacion de la notificacion", example = "1")
    private long id;
    @Schema(description = "Identificacion del Telefono al que se enviara la Notificación", example = "35112345678")
    private long nroTelefono;
    @Schema(description = "Mensaje de la notificación", example = "----PROMO FIN DE AÑO----")
    private String mensaje;

    public NotificacionDto(long nroTelefono, String mensaje) {
        this.nroTelefono = nroTelefono;
        this.mensaje = mensaje;
    }
}
