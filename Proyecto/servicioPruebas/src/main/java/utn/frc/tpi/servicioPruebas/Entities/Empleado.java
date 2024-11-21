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
@Table(name="Empleados")
public class Empleado {
    @Schema(description = "Legajo identificador del Empleado", example = "1234",required = true)
    @Id
    @GeneratedValue(generator = "Empleados")
    @TableGenerator(name= "Empleados", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue = "id",
                    initialValue = 1, allocationSize = 1)
    private long id;

    @Schema(description = "Apellido del Empleado", example = "Perez")
    @Column(name="APELLIDO")
    private String apellido;

    @Schema(description = "Nombre del Empleado", example = "Juan")
    @Column(name="NOMBRE")
    private String nombre;

    @Schema(description = "Identificacion del Telefono de contacto del Empleado", example = "35112345678")
    @Column(name="TELEFONO_CONTACTO")
    private long telefonoContacto;

    @Schema(description = "Pruebas del Empleado", example = "Prueba 1...")
    @OneToMany(mappedBy = "empleado")
    private List<Prueba> pruebas;

    public Empleado(long legajo, String apellido, String nombre, long telefonoContacto) {
        this.id = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefonoContacto = telefonoContacto;
    }
}
