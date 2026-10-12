package fase1.trabajo7.ejercicios.tres.vista;
import fase1.trabajo7.ejercicios.tres.modelo.Empleado;
import fase1.trabajo7.ejercicios.tres.controlador.empleadocontrolador;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class EmpleadoVista {
    private final empleadocontrolador controlador;
    private final Scanner sc;
    public EmpleadoVista(empleadocontrolador controlador) {
        //no se crea otra copia cuando se llama a sus metodos
        this.controlador = controlador;
        this.sc = new Scanner(System.in);
    }
    // Mostrar todos los empleados
    public void listarEmpleados() {
            List<Empleado> empleados = controlador.leerEmpleados();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE EMPLEADOS ---");

        for (Empleado e : empleados) {
            System.out.println(e);
        }

        System.out.println("Total de empleados: " + empleados.size());
    }
    // Agregar un empleado
    public void agregarEmpleado() {
        try {
            int numero = leerEntero("Numero del empleado: ");

            System.out.print("Nombre del empleado: ");
            String nombre = sc.nextLine().trim();

            if (nombre.isEmpty() || nombre.contains(";")) {
                System.out.println("Nombre invalido.");
                return;
            }

            double sueldo = leerSueldo();

            if (sueldo < 0) {
                System.out.println(
                        "El sueldo no puede ser negativo.");
                return;
            }

            Empleado nuevo =
                    new Empleado(numero, nombre, sueldo);

            boolean agregado =
                    controlador.agregarEmpleado(nuevo);

            if (agregado) {
                System.out.println(
                        "Empleado agregado correctamente.");
            } else {
                System.out.println(
                        "Ya existe un empleado con ese numero.");
            }

        } catch (IOException e) {
            System.out.println(
                    "Error al guardar el empleado: "
                    + e.getMessage());
        }
    }

    // Buscar un empleado
    public void buscarEmpleado() {
        try {
            int numero = leerEntero(
                    "Numero del empleado que desea buscar: ");

            Empleado encontrado =
                    controlador.buscarEmpleado(numero);

            if (encontrado != null) {
                System.out.println("\nEmpleado encontrado:");
                System.out.println(encontrado);
            } else {
                System.out.println(
                        "No se encontro el empleado.");
            }

        } catch (IOException e) {
            System.out.println(
                    "Error al buscar: " + e.getMessage());
        }
    }

    // Eliminar un empleado
    public void eliminarEmpleado() {
        try {
            int numero = leerEntero(
                    "Numero del empleado que desea eliminar: ");

            boolean eliminado =
                    controlador.eliminarEmpleado(numero);

            if (eliminado) {
                System.out.println(
                        "Empleado eliminado correctamente.");
            } else {
                System.out.println(
                        "No existe un empleado con ese numero.");
            }

        } catch (IOException e) {
            System.out.println(
                    "Error al eliminar: " + e.getMessage());
        }
    }

    // Leer un numero entero validado
    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: ingrese un numero entero valido.");
            }
        }
    }

    // Leer un sueldo validado
    private double leerSueldo() {
        while (true) {
            System.out.print("Sueldo del empleado: ");

            String entrada = sc.nextLine().trim()
                    .replace(',', '.');

            try {
                double sueldo = Double.parseDouble(entrada);

                if (Double.isFinite(sueldo) && sueldo >= 0) {
                    return sueldo;
                }

                System.out.println(
                        "El sueldo debe ser un numero valido "
                        + "y no negativo.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: ingrese un sueldo valido.");
            }
        }
    }
        public void iniciar() {
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE EMPLEADOS =====");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Agregar un nuevo empleado");
            System.out.println("3. Buscar empleado por numero");
            System.out.println("4. Eliminar empleado por numero");
            System.out.println("5. Salir");
            System.out.println("================================");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;

                case 2:
                    agregarEmpleado();
                    break;

                case 3:
                    buscarEmpleado();
                    break;

                case 4:
                    eliminarEmpleado();
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println(
                            "Opcion invalida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }
}


