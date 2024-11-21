package utn.frc.tpi.servicioPruebas.Services.Utils;

public class Calculo {
    public double calcularDistancia(double latitudInicial,double longitudInicial,double latitudFin,double longitudFin){
        double deltaLat = latitudFin - latitudInicial;
        double deltaLon = longitudFin - longitudInicial ;
        return  (Math.sqrt(Math.pow(deltaLat*110000, 2) + Math.pow(deltaLon*110000, 2)));
    }
}
