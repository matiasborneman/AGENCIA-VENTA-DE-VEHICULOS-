package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.ModeloDto;
import utn.frc.tpi.servicioPruebas.Entities.Modelo;

@Service
public class ModeloMapperDto implements Function<Modelo, ModeloDto> {

    @Override
    public ModeloDto apply(Modelo modelo) {
        return new ModeloDto(modelo.getId(),
                            modelo.getMarca().getId(),
                            modelo.getDescripcion());
    }
}
