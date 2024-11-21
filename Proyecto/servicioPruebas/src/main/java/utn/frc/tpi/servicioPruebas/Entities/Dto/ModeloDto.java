package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDto {
    @Schema(description = "Identificacion del modelo", example = "1")
    private long id;
    @Schema(description = "Identificacion de la marca", example = "1")
    private long idMarca;
    @Schema(description = "Descripcion de la marca", example = "...")
    private String descripcion;
}
