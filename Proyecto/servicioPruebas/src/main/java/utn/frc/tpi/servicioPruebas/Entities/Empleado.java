package utn.frc.tpi.servicioPruebas.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="Empleados")
public class Empleado {
    @Schema(description = "Legajo identificador del Empleado", example = "3")
    @Id
    @GeneratedValue(generator = "Empleados")
    @TableGenerator(name= "Empleados", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue = "ilegajo",
                    initialValue = 1, allocationSize = 1)
    private long legajo;

    @Schema(description = "Apellido del Empleado", example = "Darín")
    @Column(name="APELLIDO")
    private String apellido;

    @Schema(description = "Nombre del Empleado", example = "German")
    @Column(name="NOMBRE")
    private String nombre;

    @Schema(description = "Identificacion del Telefono de contacto del Empleado", example = "35112345678")
    @Column(name="TELEFONO_CONTACTO")
    private long telefonoContacto;

    @Schema(description = "Pruebas del Empleado", example = "Prueba 1...")
    @OneToMany(mappedBy = "empleado",fetch = FetchType.LAZY)
    private List<Prueba> pruebas;

    public Empleado(long legajo, String apellido, String nombre, long telefonoContacto) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefonoContacto = telefonoContacto;
    }
}
