package utn.frc.tpi.servicioPruebas.Services.Mappers;

import io.vavr.Function4;
import org.apache.commons.lang3.function.TriFunction;
import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.EmpleadoDto;
import utn.frc.tpi.servicioPruebas.Entities.Dto.InteresadoDto;
import utn.frc.tpi.servicioPruebas.Entities.Dto.PruebaDto;
import utn.frc.tpi.servicioPruebas.Entities.Dto.VehiculoDto;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Function;

@Service
public class PruebaMapper implements Function<PruebaDto,Prueba> {

    @Override
    public Prueba apply(PruebaDto pruebaDto) {
        return new Prueba(pruebaDto.getId(),
                pruebaDto.getComentarios(),
                pruebaDto.getFechaHoraFin(),
                pruebaDto.getFechaHoraInicio(),
                pruebaDto.isIncidente(),
                pruebaDto.getEmpleado(),
                pruebaDto.getInteresado(),
                pruebaDto.getVehiculo());
    }
}
