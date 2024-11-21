package utn.frc.tpi.servicioPruebas.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.MarcaDto;
import utn.frc.tpi.servicioPruebas.Entities.Dto.ModeloDto;
import utn.frc.tpi.servicioPruebas.Entities.Marca;
import utn.frc.tpi.servicioPruebas.Entities.Modelo;

import java.util.function.BiFunction;

@Service
public class ModeloMapper implements BiFunction<ModeloDto, MarcaDto, Modelo> {

    private MarcaMapper entityMapper;
    @Override
    public Modelo apply(ModeloDto modeloDto, MarcaDto marcaResponse) {
        Marca marca= this.entityMapper.apply(marcaResponse);
        return new Modelo(
                modeloDto.getId(),
                marca,
                modeloDto.getDescripcion());
    }
}
