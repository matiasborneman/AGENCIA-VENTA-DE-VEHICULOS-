package utn.frc.tpi.servicioPruebas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.tpi.servicioPruebas.Entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
