package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
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
    @Schema(description = "Identificacion del tipo de documento", example = "DNI")
    private String tipoDocumento;
    @Schema(description = "Numero de documento", example = "123456")
    private String documento;
    @Schema(description = "Nombre del interesado", example = "Juan")
    private String nombre;
    @Schema(description = "Apellido del interesado", example = "Perez")
    private String apellido;
    @Schema(description = "Numero de Licencia", example = "123456")
    private String numeroLicencia;
    @Schema(description = "Identificacion si el interesado esta restringido", example = "false")
    private boolean restringido;
    @Schema(description = "Fecha de vencimiento de la licencia del interesado", example = "")
    private LocalDateTime fechaVencimientoLicencia;
}
