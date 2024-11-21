package utn.frc.tpi.servicioPruebas.Entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utn.frc.tpi.servicioPruebas.Entities.Empleado;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaPostDto {
    private InteresadoDto interesado;
    private VehiculoDto vehiculo;
    private EmpleadoDto empleado;
}
