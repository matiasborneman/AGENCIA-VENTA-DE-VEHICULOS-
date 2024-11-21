package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.EmpleadoDto;
import utn.frc.tpi.servicioPruebas.Entities.Empleado;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;

import java.util.function.Function;

@Service
public class EmpleadoMapper implements Function<EmpleadoDto, Empleado> {

    @Override
    public Empleado apply(EmpleadoDto empleadoDto) {
        return new Empleado(empleadoDto.getLegajo(),
                empleadoDto.getApellido(),
                empleadoDto.getNombre(),
                empleadoDto.getTelefonoContacto());
    }
}
