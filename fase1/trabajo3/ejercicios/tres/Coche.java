package fase1.trabajo3.ejercicios.tres;

public class Coche implements Vehiculo, Motorizado {
    @Override
    public void encenderMotor() {
        System.out.println("Motor del coche encendido con la llave/botón.");
    }

    @Override
    public void acelerar() {
        System.out.println("El coche acelera inyectando combustible al motor.");
    }
}