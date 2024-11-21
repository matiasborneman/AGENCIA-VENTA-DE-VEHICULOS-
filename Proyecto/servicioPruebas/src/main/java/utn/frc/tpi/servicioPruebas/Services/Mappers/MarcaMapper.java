package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.MarcaDto;
import utn.frc.tpi.servicioPruebas.Entities.Marca;

import java.util.function.Function;

@Service
public class MarcaMapper implements Function<MarcaDto, Marca> {
    @Override
    public Marca apply(MarcaDto marcaDto) {
        return new Marca(marcaDto.getId(), marcaDto.getNombre());
    }
}
