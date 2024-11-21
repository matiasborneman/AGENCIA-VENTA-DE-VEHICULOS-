package utn.frc.tpi.servicioPruebas.Entities.AgenciaCom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utn.frc.tpi.servicioPruebas.Services.Utils.Calculo;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenciaCom {
    private CoordenadasCom coordenadasAgencia;
    private double radioMax;
    private List<ZonaRestringida> zonasRestringidas;
    public boolean exedioLimite(double latitud, double longitud){
        return  new Calculo().calcularDistancia(this.coordenadasAgencia.getLatitud(),this.coordenadasAgencia.getLongitud(),latitud,longitud) >this.radioMax;}
    public boolean seEncuentraEnZonaRestringida(double latitud, double longitud){

       return this.zonasRestringidas.stream().
               anyMatch(z ->
                       latitud <= z.getNoroeste().getLatitud() && latitud >= z.getSureste().getLatitud() &&
                       longitud >= z.getNoroeste().getLongitud() && longitud<=z.getSureste().getLongitud());
    }
}
