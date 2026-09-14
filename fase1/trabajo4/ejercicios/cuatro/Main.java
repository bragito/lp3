package fase1.trabajo4.ejercicios.cuatro;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        Registro registro = new RegistroEstudiante(5);

        try {

            registro.agregarEstudiante(
                new Estudiante(
                    "Juan",
                    "Perez",
                    "Ingenieria"
                )
            );

            registro.agregarEstudiante(
                new Estudiante(
                    "Maria",
                    "Lopez",
                    "Administracion"
                )
            );

            registro.agregarEstudiante(
                new Estudiante(
                    "Pedro",
                    "Gomez",
                    "Sistemas"
                )
            );

            System.out.println(
                "Estudiantes agregados correctamente."
            );

            Estudiante encontrado =
                registro.buscarEstudiante("Maria");

            System.out.println(
                "Estudiante encontrado: "
                + encontrado.getNombre()
                + " "
                + encontrado.getApellido()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                "Error de argumento: " + e.getMessage()
            );

        } catch (NoSuchElementException e) {

            System.out.println(
                "Error de búsqueda: " + e.getMessage()
            );
        }
    }
}
