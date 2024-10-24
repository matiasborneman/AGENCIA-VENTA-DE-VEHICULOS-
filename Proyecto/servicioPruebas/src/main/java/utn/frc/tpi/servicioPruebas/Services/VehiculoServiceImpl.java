package utn.frc.tpi.servicioPruebas.Services;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.VehiculoDto;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;
import utn.frc.tpi.servicioPruebas.Repositories.VehiculoRepository;
import utn.frc.tpi.servicioPruebas.Services.Mappers.VehiculoMapper;
import utn.frc.tpi.servicioPruebas.Services.Mappers.VehiculoMapperDto;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    private final VehiculoRepository vehiculoRepository;
    private final VehiculoMapper entityMapper;
    private final VehiculoMapperDto mapperDto;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository,
                               VehiculoMapper entityMapper,
                               VehiculoMapperDto mapperDto) {
        this.vehiculoRepository = vehiculoRepository;
        this.entityMapper = entityMapper;
        this.mapperDto = mapperDto;
    }

    @Override
    public VehiculoDto add(VehiculoDto entity) {
        return null;
    }

    @Override
    public VehiculoDto update(VehiculoDto entity) {
        return null;
    }

    @Override
    public VehiculoDto delete(Long aLong) {
        return null;
    }

    @Override
    public VehiculoDto getById(Long id) {
        Optional<Vehiculo> vehiculo = this.vehiculoRepository.findById(id);
        return vehiculo.map(mapperDto).orElseThrow();
    }

    @Override
    public List<VehiculoDto> getAll() {
        List<Vehiculo> vehiculos = this.vehiculoRepository.findAll();
        return vehiculos
                .stream()
                .map(mapperDto)
                .toList();
    }
}