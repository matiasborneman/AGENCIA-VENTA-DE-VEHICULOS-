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
@Table(name="INTERESADOS")
public class Interesado {
    @Schema(description = "Identificador del interesado", example = "1234",required = true)
    @Id
    @GeneratedValue(generator = "Interesados")
    @TableGenerator(name= "Interesados", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "id",
            initialValue = 1, allocationSize = 1)
    private long id;
    @Schema(description = "Apellido del Interesado", example = "Perez")
    @Column(name="APELLIDO")
    private String apellido;
    @Schema(description = "Documento del Interesado", example = "12345678")
    @Column(name="DOCUMENTO")
    private String documento;
    @Schema(description = "Fecha de vencimiento de la licencia del Interesado", example = "...")
    @Column(name="FECHA_VENCIMIENTO_LICENCIA")
    private LocalDateTime fechaVencimeintoLicencia;
    @Schema(description = "Nombre del Interesado", example = "Juan")
    @Column(name="NOMBRE")
    private String nombre;
    @Schema(description = "Identificacion si esta Restingido el Interesado", example = "Juan")
    @Column(name="RESTRINGIDO")
    private boolean restringido;
    @Schema(description = "Tipo documento del Interesado", example = "DNI")
    @Column(name="TIPO_DOCUMENTO")
    private String tipoDocumento;

    public boolean isValidated(){
        return ( !this.restringido || (!this.fechaVencimeintoLicencia.isBefore(LocalDateTime.now())));
    }


}
