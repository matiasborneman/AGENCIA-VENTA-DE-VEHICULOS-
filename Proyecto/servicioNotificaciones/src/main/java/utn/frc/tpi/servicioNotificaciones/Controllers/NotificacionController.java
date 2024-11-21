package utn.frc.tpi.servicioNotificaciones.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.tpi.servicioNotificaciones.Entities.Dto.NotificacionDto;
import utn.frc.tpi.servicioNotificaciones.Entities.Dto.NotificacionesDto;
import utn.frc.tpi.servicioNotificaciones.Entities.Notificacion;
import utn.frc.tpi.servicioNotificaciones.Services.NotificacionService;

import java.util.List;

@RestController
@Tag(name = "Notificaciones", description = "Catalogo de Notificaciones")
@RequestMapping("/notificacion")
public class NotificacionController {
    private NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping("/enviar-notifiacion-exceso/")
    @Operation(summary = "Envia la notificacion a un telefono")
    public ResponseEntity<NotificacionDto> sendNotification(@RequestBody NotificacionDto notificacionBody){
            try{
                NotificacionDto notificacion =  this.notificacionService.add(notificacionBody);
                return ResponseEntity.status(HttpStatus.CREATED).body(notificacion);
            } catch (EntityNotFoundException e1){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("error-message", e1.getMessage()).build();
            }

    }

    @PostMapping("/enviar-notificaciones/")
    @Operation(summary = "Envia promociones a uno o mas telefonos")
    public ResponseEntity<List<NotificacionDto>> sendPromo(@RequestBody NotificacionesDto notificacionesDto)
    {
        try{
            List<NotificacionDto> notificaciones= notificacionesDto.getTelefonos().
                    stream().map(
                            p->
                            {
                                return this.notificacionService.add((new NotificacionDto(p,notificacionesDto.getMensaje())));
                            }).toList();
            return ResponseEntity.status(HttpStatus.CREATED).body(notificaciones);
        }
        catch(EntityNotFoundException e1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header("error-message", e1.getMessage()).build();
        }
    }

    @GetMapping("/")
    @Operation(summary = "Obtiene el listado de las notificaciones")
    public ResponseEntity<List<NotificacionDto>> getAll(){
        List<NotificacionDto> notificaciones= this.notificacionService.getAll();
        return ResponseEntity.ok(notificaciones);
    }

}
