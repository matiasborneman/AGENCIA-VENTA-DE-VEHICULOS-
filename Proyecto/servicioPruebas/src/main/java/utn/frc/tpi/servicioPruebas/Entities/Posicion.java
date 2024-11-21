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
@Table(name = "Posiciones")
public class Posicion {
    @Schema(description = "Identificador de la Posicion de un vehiculo", example = "1", required = true)
    @Id
    @GeneratedValue(generator = "Posiciones")
    @TableGenerator(name = "Posiciones", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private long id;

    @Schema(description="Identificacion del vehiculo", example="1")
    @ManyToOne
    private Vehiculo vehiculo;

    @Schema(description = "Identificador de la fecha y hora de la posición", example = "...")
    @Column(name="FECHA_HORA")
    private LocalDateTime fechaHora;

    @Schema(description = "Identificador de la latitud de la posición", example = "...")
    @Column(name="LATITUD")
    private double latitud;

    @Schema(description = "Identificador de la longitud de la posición", example = "...")
    @Column(name="LONGITUD")
    private double longitud;


}
