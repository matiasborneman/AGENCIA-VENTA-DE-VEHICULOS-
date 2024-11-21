package utn.frc.tpi.servicioPruebas.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioPruebas.Entities.Dto.*;
import utn.frc.tpi.servicioPruebas.Entities.AgenciaCom.AgenciaCom;
import utn.frc.tpi.servicioPruebas.Entities.Interesado;
import utn.frc.tpi.servicioPruebas.Entities.Posicion;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;
import utn.frc.tpi.servicioPruebas.Repositories.PosicionRepository;
import utn.frc.tpi.servicioPruebas.Repositories.PruebaRepository;
import utn.frc.tpi.servicioPruebas.Services.Mappers.*;
import utn.frc.tpi.servicioPruebas.Services.Utils.Calculo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PruebaServiceImpl implements PruebaService {
    private final PruebaRepository pruebaRepository;
    private final PosicionRepository posicionRepository;
    private final PruebaMapper mapper;

    private final InteresadoMapper interesadoMapper;
    private final InteresadoMapperDto interesadoMapperDto;
    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoMapperDto empleadoMapperDto;
    private final PruebaMapperDto pruebaMapperDto;
    private final PruebaDtoMapper pruebaDtoMapper;
    private final PruebaPutPostMapper pruebaPutPostMapper;
    private final VehiculoService vehiculoService;
    private final VehiculoMapper vehiculoMapper;
    private final VehiculoMapperDto vehiculoMapperDto;
    private static  ServiceAgenciaCom serviceAgenciaCom;
    private static ServiceNotificacionCom serviceNotificacionCom;

    public PruebaServiceImpl(PruebaRepository pruebaRepository, PosicionRepository posicionRepository, PruebaMapper mapper, InteresadoMapper interesadoMapper, InteresadoMapperDto interesadoMapperDto, EmpleadoMapper empleadoMapper, EmpleadoMapperDto empleadoMapperDto, PruebaMapperDto pruebaMapperDto, PruebaDtoMapper pruebaDtoMapper, PruebaPutPostMapper pruebaPutPostMapper, VehiculoService vehiculoService, VehiculoMapper vehiculoMapper, VehiculoMapperDto vehiculoMapperDto) {
        this.pruebaRepository = pruebaRepository;
        this.posicionRepository = posicionRepository;
        this.mapper = mapper;
        this.interesadoMapper = interesadoMapper;
        this.interesadoMapperDto = interesadoMapperDto;
        this.empleadoMapper = empleadoMapper;
        this.empleadoMapperDto = empleadoMapperDto;
        this.pruebaMapperDto = pruebaMapperDto;
        this.pruebaDtoMapper = pruebaDtoMapper;
        this.pruebaPutPostMapper = pruebaPutPostMapper;
        this.vehiculoService = vehiculoService;
        this.vehiculoMapper = vehiculoMapper;
        this.vehiculoMapperDto = vehiculoMapperDto;
    }

    public PruebaDto create(PruebaPostDto prueba)//punto a
    {
        Optional<Interesado> interesado = Optional.of(this.interesadoMapper.apply(prueba.getInteresado()));
        Optional<Vehiculo> vehiculo=Optional.of(this.vehiculoMapper.apply(this.vehiculoService.getById(prueba.getVehiculo().getId())));
        Optional<Prueba>pruebaVehiculo= Optional.of(this.pruebaRepository.findByVehiculoId(vehiculo.get().getId()));
        if(interesado.get().isValidated() && !pruebaVehiculo.get().estaEnPrueba())
        {
            Optional<Prueba> pruebaCreated= Optional.of(this.pruebaPutPostMapper.apply(prueba));
            Optional<InteresadoDto> interesadoDto = Optional.of(this.interesadoMapperDto.apply(interesado.get()));
            Optional<EmpleadoDto> empleadoDto = Optional.of(prueba.getEmpleado());
            Optional<VehiculoDto> vehiculoDto= Optional.of(this.vehiculoMapperDto.apply(vehiculo.get()));
            this.pruebaRepository.saveAndFlush(pruebaCreated.get());
            return this.pruebaMapperDto.apply(pruebaCreated.get(),interesadoDto.get(),vehiculoDto.get(), empleadoDto.get());
        }
        return null;
    }
    public List<PruebaDto> getAllInProgress(LocalDateTime fechaHora)//punto b
    {
        Optional<List<Prueba>> pruebas= Optional.of(this.pruebaRepository.findAllByFechaHoraInicioBefore(fechaHora));
        if(pruebas.isEmpty()){
            throw new EntityNotFoundException(String.format("Pruebas no encontradas"));
        }
        return pruebas.get().stream()
                .filter(p->p.estaEnPrueba())
                .map(pruebaDtoMapper)
                .toList();
    }
    public PruebaDto finish( PruebaPutDto pruebaPutDto)//punto c
    {
        Optional<Prueba> prueba= this.pruebaRepository.findById(pruebaPutDto.getId());
        if(prueba.isEmpty()){
            throw new EntityNotFoundException(String.format("Prueba con id %d no encontrada", pruebaPutDto.getId()));
        }
        if(!prueba.get().getFechaHoraFin().isEqual(prueba.get().getFechaHoraInicio()))
        {
            prueba.get().finalizarPrueba(pruebaPutDto.getComentario());
        }
        this.pruebaRepository.saveAndFlush(prueba.get());
        return  this.pruebaDtoMapper.apply(prueba.get());
    }
    public NotificacionDto exceededLimits(PosicionDto posicion)//punto d
    {
        Optional<AgenciaCom>agencia= Optional.of(this.serviceAgenciaCom.agencia());
        Optional<Prueba> prueba= Optional.of(this.pruebaRepository.findByVehiculoId(posicion.getVehiculo().getId()));
        Optional<Interesado> interesado= Optional.of(prueba.get().getInteresado());
        Optional<NotificacionDto> notificacionDto= Optional.of(new NotificacionDto());
        String mensaje="";
        if(agencia.isEmpty()){
            throw new EntityNotFoundException(String.format("Agencia no encontrada"));
        }
        if(prueba.get().estaEnPrueba())
        {
            if(agencia.get().exedioLimite(posicion.getLatitud(), posicion.getLongitud())){
             mensaje= "Exedio limite el vehiculo: "+ posicion.getVehiculo().toString();
             interesado.get().setRestringido(true);
            }
            if(agencia.get().seEncuentraEnZonaRestringida(posicion.getLatitud(), posicion.getLongitud())){
                mensaje= "Se encuentra en una Zona Restringida el vehiculo: "+ posicion.getVehiculo().toString();
                interesado.get().setRestringido(true);
            }
            NotificacionDto notificacionBody= new NotificacionDto(prueba.get().getEmpleado().getTelefonoContacto(),mensaje);
            notificacionDto= Optional.of(this.serviceNotificacionCom.sendNotificacion(notificacionBody));

        }
        return notificacionDto.get();
    }
    public List<PruebaDto> getAllIncidentes()//f1
    {
        return this.pruebaRepository.findAll().
                stream().filter(p-> p.getInteresado().isRestringido())
                .map(pruebaDtoMapper).toList();
    }
    public List<PruebaDto> getAllIncidentesByEmpleado( long legajo)//f2
    {
       return this.pruebaRepository.findAllByEmpleadoId(legajo).stream()
        .filter(p -> p.getInteresado().isRestringido()).toList();

    }
    public Double getCantidadKmRecorrida( long idVehiculo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin)//f3
    {
        Optional<Posicion> posicionInicial= Optional.of(this.posicionRepository.findByFechaHoraAndVehiculoId(fechaHoraInicio, idVehiculo));
        Optional<Posicion> posicionFinal= Optional.of(this.posicionRepository.findByFechaHoraAndVehiculoId(fechaHoraFin, idVehiculo));
        return new Calculo().calcularDistancia(posicionInicial.get().getLatitud(),posicionInicial.get().getLongitud(),posicionFinal.get().getLatitud(),posicionFinal.get().getLongitud());
    }
    public List<PruebaDto> getAllByVehiculo( long id)//punto f4 reportes
    {
        return this.pruebaRepository.findAllByVehiculoId(id).
                stream()
                .map(pruebaDtoMapper)
                .toList();
    }

    @Override
    public List<PruebaDto> getAll() {
        return this.pruebaRepository.findAll().stream().map(pruebaDtoMapper).toList();
    }

    @Override
    public PruebaDto add(PruebaDto entity) {
        return null;
    }

    @Override
    public PruebaDto update(PruebaDto entity) {
        return null;
    }

    @Override
    public PruebaDto delete(Long aLong) {
        return null;
    }

    @Override
    public PruebaDto getById(Long aLong) {
        return null;
    }




}
