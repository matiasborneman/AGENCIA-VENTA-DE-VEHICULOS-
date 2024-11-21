package utn.frc.tpi.servicioPruebas.Entities.AgenciaCom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordenadasCom {

    @Schema(description = "Latitud", example = "30.509688")
    private long latitud;
    @Schema(description = "Longitud", example = "42.509688")
    private long longitud;
}
