package utn.frc.tpi.servicioPruebas.Services;

import utn.frc.tpi.servicioPruebas.Entities.Dto.*;

import java.time.LocalDateTime;
import java.util.List;

public interface PruebaService extends Service<PruebaDto,Long>{
    PruebaDto create(PruebaPostDto prueba);//a
    List<PruebaDto> getAllInProgress(LocalDateTime fechaHora);//b
    PruebaDto finish( PruebaPutDto pruebaPutDto);//c
    NotificacionDto exceededLimits(PosicionDto posicion);//d
    List<PruebaDto> getAllByVehiculo(long idVehiculo);//Reporte f4

    List<PruebaDto> getAllIncidentes();//f1

    List<PruebaDto> getAllIncidentesByEmpleado( long idEmpleado);//f2

    Double getCantidadKmRecorrida(long idVehiculo,LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin);//f3
}