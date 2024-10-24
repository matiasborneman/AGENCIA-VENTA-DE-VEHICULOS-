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
@Table(name="Empleados")
public class Empleado {
    @Schema(description = "Legajo identificador del Empleado", example = "1234",required = true)
    @Id
    @GeneratedValue(generator = "Empleados")
    @TableGenerator(name= "Empleados", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue = "legajo",
                    initialValue = 1, allocationSize = 1)
    private long legajo;

    @Schema(description = "Apellido del Empleado", example = "Perez")
    @Column(name="APELLIDO")
    private String apellido;

    @Schema(description = "Nombre del Empleado", example = "Juan")
    @Column(name="NOMBRE")
    private String nombre;

    @Schema(description = "Identificacion del Telefono de contacto del Empleado", example = "35112345678")
    @Column(name="TELEFONO_CONTACTO")
    private long telefonoContacto;
}
