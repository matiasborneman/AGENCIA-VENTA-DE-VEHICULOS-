package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.PruebaDto;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;

import java.util.function.Function;

@Service
public class PruebaDtoMapper implements Function<Prueba, PruebaDto> {
    @Override
    public PruebaDto apply(Prueba prueba) {
        return new PruebaDto(prueba.getId(),
                prueba.getComentarios(),
                prueba.getFechaHoraFin(),
                prueba.getFechaHoraInicio(),
                prueba.getEmpleado(),
                prueba.getInteresado(),
                prueba.getVehiculo());
    }
}
