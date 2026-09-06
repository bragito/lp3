package fase1.trabajo3.ejercicios.dos.vehiculos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
            new Coche(),
            new Bicicleta()
        );

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.acelerar();
        }
    }
}