package utn.frc.tpi.servicioPruebas.Services.Mappers;

import io.vavr.Function4;
import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.*;
import utn.frc.tpi.servicioPruebas.Entities.Dto.*;
@Service
public class PruebaMapperDto implements Function4<Prueba, InteresadoDto, VehiculoDto, EmpleadoDto, PruebaDto> {

   private InteresadoMapper interesadoMapper;
   private VehiculoMapper vehiculoMapper;
   private EmpleadoMapper empleadoMapper;
   private ModeloMapper modeloMapper;
   private MarcaMapperDto marcaMapper;
   @Override
    public PruebaDto apply(Prueba prueba, InteresadoDto interesadoResponse, VehiculoDto vehiculoDto, EmpleadoDto empleadoDto) {
       Interesado interesado= this.interesadoMapper.apply(interesadoResponse);
       Vehiculo vehiculo= this.vehiculoMapper.apply(vehiculoDto);
       Empleado empleado= this.empleadoMapper.apply(empleadoDto);
       return new PruebaDto(prueba.getId(),
               prueba.getComentarios(),
               prueba.getFechaHoraFin(),
               prueba.getFechaHoraInicio(),
               empleado,
               interesado,
               vehiculo
       );
    }
}
