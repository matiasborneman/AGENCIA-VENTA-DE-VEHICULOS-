package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utn.frc.tpi.servicioPruebas.Entities.Empleado;
import utn.frc.tpi.servicioPruebas.Entities.Interesado;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaDto {

    @Schema(description = "Identificador de la Prueba", example = "1234",required = true)
    private long id;

    @Schema(description = "Comentario de la prueba", example = "....")
    private String comentarios;

    @Schema(description = "Identificador de la fecha y hora de fin de la prueba", example = "...")
    private LocalDateTime fechaHoraFin;

    @Schema(description = "Identificador de la fecha y hora de inicio de la prueba", example = "...")
    private LocalDateTime fechaHoraInicio;

    @Schema(description = "Identificador del Empleado de la prueba", example = "1")
    private Empleado empleado;

    @Schema(description = "Identificador del Interesado de la prueba", example = "1")
    private Interesado interesado;

    @Schema(description = "Identificador del Vehiculo de la prueba", example = "1")
    private Vehiculo vehiculo;

}
