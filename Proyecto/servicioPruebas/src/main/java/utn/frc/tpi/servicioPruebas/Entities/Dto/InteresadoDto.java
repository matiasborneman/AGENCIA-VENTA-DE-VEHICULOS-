package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InteresadoDto {
    @Schema(description = "Identificacion del interesado", example = "1")
    private long id;
    @Schema(description = "Identificacion del tipo de documento", example = "1")
    private String tipoDocumento;
    @Schema(description = "Numero de documento", example = "1")
    private String documento;
    @Schema(description = "Nombre del interesado", example = "1")
    private String nombre;
    @Schema(description = "Apellido del interesado", example = "1")
    private String apellido;
    @Schema(description = "Identificacion si el interesado esta restringido", example = "true")
    private boolean restringido;
    @Schema(description = "Fecha de vencimiento de la licencia del interesado", example = "")
    private LocalDateTime fechaVencimientoLicencia;
}
