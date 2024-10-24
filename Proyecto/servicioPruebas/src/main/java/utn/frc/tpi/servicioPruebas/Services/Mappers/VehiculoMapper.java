package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.VehiculoDto;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;

import java.util.function.Function;

@Service
public class VehiculoMapper implements Function<VehiculoDto, Vehiculo> {

    @Override
    public Vehiculo apply(VehiculoDto vehiculoDto) {
        return new Vehiculo(vehiculoDto.getId(),
                vehiculoDto.getAnio(),
                vehiculoDto.getIdModelo(),
                vehiculoDto.getPatente());
    }
}
