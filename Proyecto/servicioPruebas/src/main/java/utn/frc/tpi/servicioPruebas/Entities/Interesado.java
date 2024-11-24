package utn.frc.tpi.servicioPruebas.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Schema(description = "Numero de Licencia", example = "123456")
    @Column(name="NRO_LICENCIA")
    private String numeroLicencia;
    @Schema(description = "Identificacion si esta Restingido el Interesado", example = "false")
    @Column(name="RESTRINGIDO")
    private boolean restringido;
    @Schema(description = "Tipo documento del Interesado", example = "DNI")
    @Column(name="TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Schema(description = "Pruebas del Interesado", example = "Prueba 1...")
    @OneToMany(mappedBy = "interesado",fetch = FetchType.LAZY)
    private List<Prueba> pruebas;

    public boolean isValidated(){
        return ( !this.restringido || (!this.fechaVencimeintoLicencia.isBefore(LocalDateTime.now())));
    }


}
