package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.InteresadoDto;
import utn.frc.tpi.servicioPruebas.Entities.Interesado;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class InteresadoMapper implements Function<InteresadoDto, Interesado> {
    @Override
    public Interesado apply(InteresadoDto interesadoDto) {
        return new Interesado(interesadoDto.getId(),
                interesadoDto.getApellido(),
                interesadoDto.getDocumento(),
                interesadoDto.getFechaVencimientoLicencia(),
                interesadoDto.getNombre(),
                interesadoDto.getNumeroLicencia(),
                interesadoDto.isRestringido(),
                interesadoDto.getTipoDocumento(),new ArrayList<>());
    }
}
