package utn.frc.tpi.servicioNotificaciones.Services;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioNotificaciones.Entities.Dto.NotificacionDto;
import utn.frc.tpi.servicioNotificaciones.Entities.Dto.NotificacionesDto;
import utn.frc.tpi.servicioNotificaciones.Entities.Notificacion;
import utn.frc.tpi.servicioNotificaciones.Repositories.NotificacionRepository;
import utn.frc.tpi.servicioNotificaciones.Services.Mappers.NotificacionMapper;
import utn.frc.tpi.servicioNotificaciones.Services.Mappers.NotificacionMapperDto;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImpl implements NotificacionService{
    private final NotificacionRepository notificacionRepository;
    private final NotificacionMapper entityMapper;
    private final NotificacionMapperDto mapperDto;

    public NotificacionServiceImpl(NotificacionRepository notificacionRepository, NotificacionMapper entityMapper, NotificacionMapperDto mapperDto) {
        this.notificacionRepository = notificacionRepository;
        this.entityMapper = entityMapper;
        this.mapperDto = mapperDto;
    }

    @Override
    public NotificacionDto add(NotificacionDto entity) {
        Optional<Notificacion> notificacion = Optional.of(this.entityMapper.apply(entity));
        this.notificacionRepository.saveAndFlush(notificacion.get());
        return notificacion.map(mapperDto).orElseThrow();
    }
    @Override
    public NotificacionDto update(NotificacionDto entity) {
        return null;
    }

    @Override
    public NotificacionDto delete(Long aLong) {
        return null;
    }

    @Override
    public NotificacionDto getById(Long aLong) {
        return null;
    }

    @Override
    public List<NotificacionDto> getAll() {
        List<Notificacion> notificaciones = this.notificacionRepository.findAll();
        return notificaciones
                .stream()
                .map(mapperDto)
                .toList();
    }
}
