package utn.frc.tpi.servicioPruebas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.tpi.servicioPruebas.Entities.Dto.PruebaDto;
import utn.frc.tpi.servicioPruebas.Entities.Prueba;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba,Long> {

    List<Prueba> findAllByFechaHoraInicioBefore(LocalDateTime date);

    Prueba findByVehiculoId(long idVehiculo);

    List<Prueba> findAllByVehiculoId(long idVehiculo);

    List<PruebaDto> findAllByEmpleadoId(long idEmpleado);
}
