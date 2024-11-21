package utn.frc.tpi.servicioNotificaciones.Services.Mappers;

import org.springframework.stereotype.Service;
import utn.frc.tpi.servicioNotificaciones.Entities.Dto.NotificacionDto;
import utn.frc.tpi.servicioNotificaciones.Entities.Notificacion;

import java.util.function.Function;

@Service
public class NotificacionMapperDto implements Function<Notificacion, NotificacionDto> {
    @Override
    public NotificacionDto apply(Notificacion notificacion) {
        return new NotificacionDto(notificacion.getId(),
                notificacion.getNroTelefono(),
                notificacion.getMensaje());
    }
}
