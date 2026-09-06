package fase1.trabajo3.ejercicios.tres;

public class Bicicleta implements Vehiculo {
    // La bicicleta solo es un Vehiculo, no implementa Motorizado
    @Override
    public void acelerar() {
        System.out.println("La bicicleta acelera mediante fuerza humana (pedaleo).");
    }
}