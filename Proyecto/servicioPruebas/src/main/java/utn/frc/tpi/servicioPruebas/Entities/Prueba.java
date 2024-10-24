package utn.frc.tpi.servicioPruebas.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pruebas")
public class Prueba {
    @Schema(description = "Identificador de la Prueba", example = "1234",required = true)
    @Id
    @GeneratedValue(generator = "Pruebas")
    @TableGenerator(name= "Pruebas", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "id",
            initialValue = 1, allocationSize = 1)
    private long id;

    @Schema(description = "Comentario de la prueba", example = "....")
    @Column(name="COMENTARIOS")
    private String comentarios;

    @Schema(description = "Identificador de la fecha y hora de fin de la prueba", example = "...")
    @Column(name="FECHA_HORA_FIN")
    private LocalDateTime fechaHoraFin;

    @Schema(description = "Identificador de la fecha y hora de inicio de la prueba", example = "...")
    @Column(name="FECHA_HORA_INICIO")
    private LocalDateTime fechaHoraInicio;

    @Schema(description = "Identificador del Empleado de la prueba", example = "1")
    @Column(name="ID_EMPLEADO")
    private long idEmpleado;

    @Schema(description = "Identificador del Interesado de la prueba", example = "1")
    @Column(name="ID_INTERESADO")
    private long idInteresado;

    @Schema(description = "Identificador del Vehiculo de la prueba", example = "1")
    @Column(name="ID_VEHICULO")
    private long idVehiculo;
}
