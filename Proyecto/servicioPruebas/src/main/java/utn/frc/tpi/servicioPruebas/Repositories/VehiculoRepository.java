package utn.frc.tpi.servicioPruebas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
