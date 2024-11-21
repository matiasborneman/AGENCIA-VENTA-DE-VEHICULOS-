package utn.frc.tpi.servicioPruebas.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name="ID_MODELO")
    private Modelo modelo;


    @Schema(description = "Identificacion de la patente del vehiculo", example = "AB 123 CD")
    @Column(name="PATENTE")
    private String patente;

    @Schema(description = "Pruebas del Vehiculo", example = "Prueba 1...")
    @OneToMany(mappedBy = "vehiculo")
    private List<Prueba> pruebas;

    @Schema(description = "Posiciones del Vehiculo", example = "Posicion hora...")
    @OneToMany(mappedBy = "vehiculo")
    private List<Posicion> posiciones;

    public Vehiculo(long id, Long anio, Modelo modelo, String patente) {
        this.id = id;
        this.anio = anio;
        this.modelo = modelo;
        this.patente = patente;
    }

}
