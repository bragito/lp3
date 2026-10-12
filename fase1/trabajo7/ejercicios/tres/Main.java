package fase1.trabajo7.ejercicios.tres;
import fase1.trabajo7.ejercicios.tres.controlador.empleadocontrolador;
import fase1.trabajo7.ejercicios.tres.vista.EmpleadoVista;


public class Main {

    public static void main(String[] args) {

        empleadocontrolador controlador =
                new empleadocontrolador();

        EmpleadoVista vista =
                new EmpleadoVista(controlador);

        // Mostrar los empleados al iniciar
        vista.listarEmpleados();

        // Iniciar el menu principal
        vista.iniciar();
    }
}