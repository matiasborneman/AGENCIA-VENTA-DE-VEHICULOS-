package utn.frc.tpi.servicioPruebas.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.tpi.servicioPruebas.Entities.Dto.*;
import utn.frc.tpi.servicioPruebas.Entities.Posicion;
import utn.frc.tpi.servicioPruebas.Services.PruebaService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Tag(name="Pruebas",description = "Catalogo de Pruebas")
@RequestMapping("/")
public class PruebaController {
    private final PruebaService pruebaService;

    public PruebaController(PruebaService pruebaService) {
        this.pruebaService = pruebaService;
    }
    @GetMapping("/")
    @Operation(summary = "Obtiene el listado de Pruebas")
    public ResponseEntity<List<PruebaDto>> getAll() {
        List<PruebaDto> pruebas = this.pruebaService.getAll();
        return ResponseEntity.ok(pruebas);
    }
    @PostMapping("/crear-prueba")
    @Operation(summary = "Crea una Prueba con los atributos iniciales seteados")
    public ResponseEntity<PruebaDto> create(@RequestBody PruebaPostDto pruebaPostDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(this.pruebaService.create(pruebaPostDto));
        } catch (EntityNotFoundException e1) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .header("error-message", e1.getMessage())
                    .build();
        }
    }
    @PutMapping("/finalizar-prueba")
    @Operation(summary = "Finaliza una Prueba a partir de su id y el comentario")
    public ResponseEntity<PruebaDto> finish(@RequestBody PruebaPutDto pruebaPutDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    this.pruebaService.finish(pruebaPutDto)
            );
        } catch (EntityNotFoundException e1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("error-message", e1.getMessage()).build();
        } catch (ServiceException e2) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .header("error-message", e2.getMessage()).build();
        }

    }
    @GetMapping("/pruebas-en-curso/")
    @Operation(summary = "Obtiene el listado de Pruebas")
    public ResponseEntity<List<PruebaDto>> getAllInProcess(@RequestParam LocalDateTime dateTime) {
       List<PruebaDto> pruebas = this.pruebaService.getAllInProgress(dateTime);
       return ResponseEntity.ok(pruebas);
    }
    @PostMapping("/enviar-posicion/")
    @Operation(summary = "Recibe una posicion y evalua si excedio los limites")
    public ResponseEntity<NotificacionDto> exceededLimits(@RequestBody PosicionDto posicionDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.pruebaService.exceededLimits(posicionDto));
        } catch (EntityNotFoundException e1) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .header("error-message", e1.getMessage())
                    .build();
        }
    }
    @GetMapping("/reportes/{id}/prueba-vehiculo")
    @Operation(summary = "Obtiene el listado de Pruebas")
    public ResponseEntity<List<PruebaDto>> getAllByVehiculo(@PathVariable("id") Long idVehiculo) {
        List<PruebaDto> pruebas = this.pruebaService.getAllByVehiculo(idVehiculo);
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/reportes/prueba-incidentes/")
    @Operation(summary = "Obtiene el listado de puebas que excedieron los limites")
    public ResponseEntity<List<PruebaDto>> getAllIncidentes()
    {
        List<PruebaDto> pruebas = this.pruebaService.getAllIncidentes();
        return ResponseEntity.ok(pruebas);
    }
    @GetMapping("/reportes/{id}/kilometros-recorridos/")
    @Operation(summary = "Obtiene la cantidad de kilometros recorridos por un vehiculo en un tiempo determinado")
    public ResponseEntity<Double> getKilometrosRecorridos(@PathVariable("id") Long idVehiculo,
                                                          @RequestParam LocalDateTime fechaHoraInicio,
                                                          @RequestParam LocalDateTime fechaHoraFin
                                                          ){
        return ResponseEntity.ok(this.pruebaService.getCantidadKmRecorrida(idVehiculo,fechaHoraInicio, fechaHoraFin));
    }
    @GetMapping("/reportes/{id}/prueba-incidentes/")
    @Operation(summary = "Obtiene el listado de puebas que excedieron los limites para un empleado")
    public ResponseEntity<List<PruebaDto>> getAllIncidentesByEmpleado(@PathVariable("id") Long idEmpleado)
    {
        List<PruebaDto> pruebas = this.pruebaService.getAllIncidentesByEmpleado(idEmpleado);
        return ResponseEntity.ok(pruebas);
    }
}
