package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDto {
    @Schema(description = "Identificador de la Posicion de un vehiculo", example = "1")
    private long id;

    @Schema(description="Identificacion del vehiculo", example="1")
    private Vehiculo vehiculo;

    @Schema(description = "Identificador de la fecha y hora de la posición", example = "...")
    private LocalDateTime fechaHora;

    @Schema(description = "Identificador de la latitud de la posición", example = "...")
    private double latitud;

    @Schema(description = "Identificador de la longitud de la posición", example = "...")
    private double longitud;
}
