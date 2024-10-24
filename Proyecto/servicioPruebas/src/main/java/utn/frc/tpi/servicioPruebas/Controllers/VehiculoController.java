package utn.frc.tpi.servicioPruebas.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utn.frc.tpi.servicioPruebas.Entities.Dto.VehiculoDto;
import utn.frc.tpi.servicioPruebas.Entities.Vehiculo;
import utn.frc.tpi.servicioPruebas.Services.VehiculoService;

import java.util.List;

@RestController
@Tag(name="Vehiculos",description = "Catalogo de Vehiculos")
@RequestMapping("/vehiculo")
public class VehiculoController {

    private VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    @GetMapping
    @Operation(summary = "Obtiene el listado de Vehiculos")
    public ResponseEntity<List<VehiculoDto>> getAll() {
        List<VehiculoDto> vehiculo = this.vehiculoService.getAll();
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping
    @Operation(summary = "Registra un nuevo vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra el vehiculo", content = @Content(schema = @Schema(implementation = Vehiculo.class)))
    })
    public ResponseEntity<VehiculoDto> add(@RequestBody VehiculoDto estacionDto) {
        VehiculoDto vehiculo =  this.vehiculoService.add(estacionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un vehiculo determinado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el Vehiculo", content = @Content(schema = @Schema(implementation = Vehiculo.class))),
            @ApiResponse(responseCode = "404", description = "El vehiculo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    public ResponseEntity<VehiculoDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.vehiculoService.getById(id));
}
}
