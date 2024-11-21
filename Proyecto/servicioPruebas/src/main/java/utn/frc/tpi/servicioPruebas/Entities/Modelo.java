package utn.frc.tpi.servicioPruebas.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Modelos")
public class Modelo {
    @Schema(description = "Identificador del modelo", example = "1", required = true)
    @Id
    @GeneratedValue(generator = "Modelos")
    @TableGenerator(name = "Modelos", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private  long id;

    @Schema(description = "Identificacion de la marca del vehiculo", example = "12")
    @ManyToOne
    private Marca marca;

    @Schema(description = "Descripción del modelo", example = ".....")
    @Column(name="DESCRIPCION")
    private String descripcion;

}
