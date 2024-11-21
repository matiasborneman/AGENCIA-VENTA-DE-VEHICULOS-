package utn.frc.tpi.servicioNotificaciones.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioNotificaciones.Entities.Dto.NotificacionDto;
import utn.frc.tpi.servicioNotificaciones.Entities.Notificacion;

import java.util.function.Function;

@Service
public class NotificacionMapper implements Function<NotificacionDto, Notificacion> {
    @Override
    public Notificacion apply(NotificacionDto notificacionDto) {
        return new Notificacion(notificacionDto.getId(),
                notificacionDto.getNroTelefono(),
                notificacionDto.getMensaje());
    }
}
