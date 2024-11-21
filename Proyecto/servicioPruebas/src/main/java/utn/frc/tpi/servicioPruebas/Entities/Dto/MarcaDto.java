package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDto {
    @Schema(description = "Identificacion de la marca", example = "1")
    private long id;
    @Schema(description = "Identificacion del nombre la marca", example = "1")
    private String nombre;
}
