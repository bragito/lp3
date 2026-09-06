package fase1.trabajo3.ejercicios.tres;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> flota = List.of(new Coche(), new Bicicleta());

        // Polimorfismo seguro (LSP): Todos los vehículos aceleran de forma consistente
        for (Vehiculo v : flota) {
            v.acelerar();
        }
    }
}