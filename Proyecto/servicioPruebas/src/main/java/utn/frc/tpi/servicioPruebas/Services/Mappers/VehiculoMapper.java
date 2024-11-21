package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.apache.commons.lang3.function.TriFunction;
import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.MarcaDto;
import utn.frc.tpi.servicioPruebas.Entities.Dto.ModeloDto;
import utn.frc.tpi.servicioPruebas.Entities.Dto.VehiculoDto;
import utn.frc.tpi.servicioPruebas.Entities.Modelo;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;

import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class VehiculoMapper implements Function<VehiculoDto,Vehiculo> {

    private ModeloMapper entityMapper;
    @Override
    public Vehiculo apply(VehiculoDto vehiculoDto) {
         return new Vehiculo(vehiculoDto.getId(),
                vehiculoDto.getAnio(),
                vehiculoDto.getIdModelo(),
                vehiculoDto.getPatente());
    }
}
