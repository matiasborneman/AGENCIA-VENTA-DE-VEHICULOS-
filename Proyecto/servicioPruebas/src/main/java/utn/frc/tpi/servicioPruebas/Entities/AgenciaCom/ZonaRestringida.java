package utn.frc.tpi.servicioPruebas.Entities.AgenciaCom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZonaRestringida {

    @Schema(description = "Cordenadas noroeste", example = "latitud: 42.509688, longitud:53.509688 ")
    private CoordenadasCom noroeste;
    @Schema(description = "Cordenadas sureste", example = "latitud: 42.509688, longitud:53.509688 ")
    private CoordenadasCom sureste;
}
