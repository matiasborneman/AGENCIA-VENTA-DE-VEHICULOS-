package utn.frc.tpi.servicioNotificaciones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.tpi.servicioNotificaciones.Entities.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion,Long> {
}
