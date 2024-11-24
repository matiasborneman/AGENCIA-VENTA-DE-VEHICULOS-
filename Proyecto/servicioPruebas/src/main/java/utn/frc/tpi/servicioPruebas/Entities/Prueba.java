package utn.frc.tpi.servicioPruebas.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pruebas")
public class Prueba {
    @Schema(description = "Identificador de la Prueba", example = "1234")
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

    @Schema(description = "Indicador si la prueba tuvo incidentes", example = "false")
    @Column(name="INCIDENTE")
    private boolean incidente;

    @Schema(description = "Identificador del Empleado de la prueba", example = "1")
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO")
    private Empleado empleado;

    @Schema(description = "Identificador del Interesado de la prueba", example = "1")
    @ManyToOne (fetch= FetchType.LAZY)
    @JoinColumn(name = "ID_INTERESADO")
    private Interesado interesado;

    @Schema(description = "Identificador del Vehiculo de la prueba", example = "1")
    @ManyToOne (fetch= FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICULO")
    private Vehiculo vehiculo;

    public Prueba(Empleado empleado, Interesado interesado, Vehiculo vehiculo) {
        this.fechaHoraInicio = LocalDateTime.now();
        this.fechaHoraFin= LocalDateTime.now();
        this.incidente=false;
        this.empleado = empleado;
        this.interesado = interesado;
        this.vehiculo = vehiculo;
    }

    public Prueba finalizarPrueba(String comentarios){
        this.comentarios=comentarios;
        this.fechaHoraFin= LocalDateTime.now();
        return this;
    }
    public boolean estaEnPrueba()
    {
        return this.fechaHoraInicio.isEqual(this.fechaHoraFin);
    }
}
