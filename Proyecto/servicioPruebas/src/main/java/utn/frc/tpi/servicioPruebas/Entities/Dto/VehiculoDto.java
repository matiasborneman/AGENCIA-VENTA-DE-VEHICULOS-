package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    @Schema(description = "Identificacion del vehiculo", example = "1")
    private long id;
    @Schema(description="Identificacion del año del vehiculo", example="1")
    private Long anio;
    @Schema(description="Identificacion del modelo del vehiculo", example="1")
    private Long idModelo;
    @Schema(description = "Identificacion de la patente del vehiculo", example = "AB 123 CD")
    private String patente;

}
