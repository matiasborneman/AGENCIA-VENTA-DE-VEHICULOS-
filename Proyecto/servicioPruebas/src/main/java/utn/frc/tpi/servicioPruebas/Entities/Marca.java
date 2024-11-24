package utn.frc.tpi.servicioPruebas.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Marcas")
public class Marca {
    @Schema(description = "Identificador de la marca", example = "1", required = true)
    @Id
    @GeneratedValue(generator = "Marcas")
    @TableGenerator(name = "Marcas", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private long id;

    @Schema(description = "Nombre de la marca", example = ".....")
    @Column(name="NOMBRE")
    private String nombre;

    @Schema(description = "Modelos", example = ".....")
    @OneToMany(mappedBy = "marca",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Modelo> modelos;

    public Marca(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
