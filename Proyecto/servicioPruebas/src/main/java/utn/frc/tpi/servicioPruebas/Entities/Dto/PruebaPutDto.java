package utn.frc.tpi.servicioPruebas.Entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaPutDto {
    private long id;
    private String comentario;
}
