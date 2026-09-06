package actividades.tres;

public class TestAgregacion {
    public static void main(String[] args) {

        // Crear objetos Motor
        Motor motor1 = new Motor(1001, 3000);
        Motor motor2 = new Motor(1002, 2500);

        // Crear objetos Automovil
        Automovil auto1 = new Automovil(
                "ABC-123", 4, "Toyota", "Corolla");

        Automovil auto2 = new Automovil(
                "XYZ-456", 2, "Ford", "Mustang");

        // Asignar un motor a cada automóvil
        auto1.setMotor(motor1);
        auto2.setMotor(motor2);

        // Mostrar los datos
        System.out.println("DATOS DEL AUTOMOVIL 1");
        System.out.println(auto1);

        System.out.println("\nDATOS DEL AUTOMOVIL 2");
        System.out.println(auto2);

        // Mostrar los datos de los motores
        System.out.println("\nDATOS DE LOS MOTORES");
        System.out.println("Motor 1: " + motor1);
        System.out.println("Motor 2: " + motor2);
    }
}
