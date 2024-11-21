package utn.frc.tpi.servicioPruebas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.tpi.servicioPruebas.Entities.Posicion;

import java.time.LocalDateTime;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Long> {

    Posicion findByFechaHoraAndVehiculoId(LocalDateTime fechaHoraInicio, long vehiculoId);
}
