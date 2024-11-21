package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.EmpleadoDto;
import utn.frc.tpi.servicioPruebas.Entities.Empleado;

import java.util.function.Function;

@Service
public class EmpleadoMapperDto implements Function<Empleado, EmpleadoDto> {
    @Override
    public EmpleadoDto apply(Empleado empleado) {
        return new EmpleadoDto(empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getTelefonoContacto());
    }
}
