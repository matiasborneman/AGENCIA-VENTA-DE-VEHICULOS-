package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.VehiculoDto;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;

import java.util.function.Function;

@Service
public class VehiculoMapperDto implements Function<Vehiculo, VehiculoDto> {
    @Override
    public VehiculoDto apply(Vehiculo vehiculo) {
        return new VehiculoDto(vehiculo.getId(),
                                vehiculo.getAnio(),
                                vehiculo.getModelo(),
                                vehiculo.getPatente());
    }
}
