package utn.frc.tpi.servicioPruebas.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Vehiculos")
public class Vehiculo {
    @Schema(description = "Identificador del vehiculo", example = "1", required = true)
    @Id
    @GeneratedValue(generator = "Vehiculos")
    @TableGenerator(name = "Vehiculos", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private long id;

    @Schema(description="Identificacion del año del vehiculo", example="1")
    @Column(name="ANIO")
    private Long anio;

    @Schema(description="Identificacion del modelo del vehiculo", example="1")
    @Column(name="ID_MODELO")
    private Long idModelo;


    @Schema(description = "Identificacion de la patente del vehiculo", example = "AB 123 CD")
    @Column(name="PATENTE")
    private String patente;

}
