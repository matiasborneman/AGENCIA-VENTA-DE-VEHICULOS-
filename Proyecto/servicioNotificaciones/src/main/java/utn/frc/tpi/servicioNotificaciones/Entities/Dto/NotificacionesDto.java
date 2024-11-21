package utn.frc.tpi.servicioNotificaciones.Entities.Dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionesDto {
    @Schema(description = "Lista de Telefonos a los que se enviara la Notificación", example = "35112345678, ...")
    private List<Long> telefonos;

    @Schema(description = "Mensaje que se enviara como Notificación", example = " promocion")
    private String mensaje;
}
