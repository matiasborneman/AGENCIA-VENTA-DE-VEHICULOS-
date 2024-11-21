package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.PruebaPostDto;
import utn.frc.tpi.servicioPruebas.Entities.Empleado;
import utn.frc.tpi.servicioPruebas.Entities.Interesado;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;

import java.util.function.Function;

@Service
public class PruebaPutPostMapper implements Function<PruebaPostDto, Prueba> {

    EmpleadoMapper empleadoMapper;
    InteresadoMapper interesadoMapper;
    VehiculoMapper vehiculoMapper;
    @Override
    public Prueba apply(PruebaPostDto pruebaPostDto) {
        Empleado empleado= this.empleadoMapper.apply(pruebaPostDto.getEmpleado());
        Interesado interesado= this.interesadoMapper.apply(pruebaPostDto.getInteresado());
        Vehiculo  vehiculo= vehiculoMapper.apply(pruebaPostDto.getVehiculo());
        return new Prueba(empleado,
                interesado,
                vehiculo);
    }
}
