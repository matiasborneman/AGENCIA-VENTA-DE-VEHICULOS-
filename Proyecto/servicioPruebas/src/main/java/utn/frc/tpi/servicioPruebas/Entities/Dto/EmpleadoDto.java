package utn.frc.tpi.servicioPruebas.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {
    @Schema(description = "Identificacion del empleado", example = "1")
    private long legajo;
    @Schema(description = "Nombre del empleado", example = "1")
    private String nombre;
    @Schema(description = "Apellido del empleado", example = "1")
    private String apellido;
    @Schema(description = "Telefono de contacto del empleado", example = "1")
    private long telefonoContacto;
}
