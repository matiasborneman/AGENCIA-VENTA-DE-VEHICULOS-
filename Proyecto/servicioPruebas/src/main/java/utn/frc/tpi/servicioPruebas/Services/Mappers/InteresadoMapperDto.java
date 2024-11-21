package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.InteresadoDto;
import utn.frc.tpi.servicioPruebas.Entities.Interesado;

import java.util.function.Function;

@Service
public class InteresadoMapperDto implements Function<Interesado, InteresadoDto> {
    @Override
    public InteresadoDto apply(Interesado interesado) {
        return new InteresadoDto(interesado.getId(),
                interesado.getTipoDocumento(),
                interesado.getDocumento(),
                interesado.getNombre(),
                interesado.getApellido(),
                interesado.isRestringido(),
                interesado.getFechaVencimeintoLicencia());
    }
}
