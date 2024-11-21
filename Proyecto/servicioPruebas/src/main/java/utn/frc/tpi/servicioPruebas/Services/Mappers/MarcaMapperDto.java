package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.MarcaDto;
import utn.frc.tpi.servicioPruebas.Entities.Marca;

import java.util.function.Function;

@Service
public class MarcaMapperDto implements Function<Marca, MarcaDto> {
    @Override
    public MarcaDto apply(Marca marca) {

        return new MarcaDto(marca.getId(), marca.getNombre());
    }
}
