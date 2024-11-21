package utn.frc.tpi.servicioNotificaciones.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Notificaciones")
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {
    @Schema(description = "Identificador de la Notificación", example = "1234",required = true)
    @Id
    @GeneratedValue(generator = "Notificaciones")
    @TableGenerator(name= "Notificaciones", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "id",
            initialValue = 1, allocationSize = 1)
    private long id;

    @Schema(description = "Identificacion del Telefono al que se enviara la Notificación", example = "35112345678")
    @Column(name="Telefono_contacto")
    private long nroTelefono;

    @Schema(description = "Mensaje de la notificación", example = "----PROMO FIN DE AÑO----")
    @Column(name="MENSAJE")
    private String mensaje;

    public Notificacion(long nroTelefono, String mensaje) {
        this.nroTelefono = nroTelefono;
        this.mensaje = mensaje;
    }
}
