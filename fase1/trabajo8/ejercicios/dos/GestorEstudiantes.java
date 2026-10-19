package fase1.trabajo8.ejercicios.dos;

import java.sql.*;
import java.util.Arrays;
import java.util.Comparator;

public class GestorEstudiantes {

    private final String URL = "jdbc:sqlite:universidad.db";

    // Cargar todos los registros en un arreglo
    public Estudiante[] cargarRegistros() throws SQLException {

        Estudiante[] estudiantes = new Estudiante[0];

        try (Connection con = DriverManager.getConnection(URL);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM estudiantes")) {

            while (rs.next()) {
                Estudiante e = new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("carrera")
                );

                estudiantes = Arrays.copyOf(
                    estudiantes, estudiantes.length + 1
                );

                estudiantes[estudiantes.length - 1] = e;
            }
        }

        return estudiantes;
    }

    // Consultar, filtrar, ordenar y limitar desde Java
    public void consultar(
            String[] campos,
            String campoCondicion,
            String operador,
            String valor,
            String campoOrden,
            boolean descendente,
            int limite) throws SQLException {

        Estudiante[] datos = cargarRegistros();

        // Aplicar la condición
        if (!campoCondicion.equals("ninguno")) {
            int cantidad = 0;

            for (Estudiante e : datos) {
                if (cumpleCondicion(e, campoCondicion, operador, valor)) {
                    cantidad++;
                }
            }

            Estudiante[] filtrados = new Estudiante[cantidad];
            int i = 0;

            for (Estudiante e : datos) {
                if (cumpleCondicion(e, campoCondicion, operador, valor)) {
                    filtrados[i++] = e;
                }
            }

            datos = filtrados;
        }

        // Ordenar por el campo elegido
        if (!campoOrden.equals("ninguno")) {
            Comparator<Estudiante> comparador;

            switch (campoOrden) {
                case "id":
                    comparador = Comparator.comparingInt(Estudiante::getId);
                    break;
                case "edad":
                    comparador = Comparator.comparingInt(Estudiante::getEdad);
                    break;
                case "nombre":
                    comparador = Comparator.comparing(
                        Estudiante::getNombre,
                        String.CASE_INSENSITIVE_ORDER
                    );
                    break;
                default:
                    comparador = Comparator.comparing(
                        Estudiante::getCarrera,
                        String.CASE_INSENSITIVE_ORDER
                    );
            }

            if (descendente) {
                comparador = comparador.reversed();
            }

            Arrays.sort(datos, comparador);
        }

        // Limitar la cantidad de resultados
        if (limite > 0 && limite < datos.length) {
            datos = Arrays.copyOf(datos, limite);
        }

        // Mostrar solamente los campos elegidos
        System.out.println("\n===== RESULTADOS =====");

        if (datos.length == 0) {
            System.out.println("No se encontraron registros.");
            return;
        }

        for (Estudiante e : datos) {
            for (String campo : campos) {
                switch (campo) {
                    case "id":
                        System.out.print("ID: " + e.getId() + " | ");
                        break;
                    case "nombre":
                        System.out.print("Nombre: " + e.getNombre() + " | ");
                        break;
                    case "edad":
                        System.out.print("Edad: " + e.getEdad() + " | ");
                        break;
                    case "carrera":
                        System.out.print("Carrera: " + e.getCarrera() + " | ");
                        break;
                }
            }

            System.out.println();
        }
    }

    // Evaluar las condiciones sin usar SQL
    private boolean cumpleCondicion(
            Estudiante e, String campo, String operador, String valor) {

        String dato;

        switch (campo) {
            case "id":
                dato = String.valueOf(e.getId());
                break;
            case "nombre":
                dato = e.getNombre();
                break;
            case "edad":
                dato = String.valueOf(e.getEdad());
                break;
            default:
                dato = e.getCarrera();
        }

        if (operador.equals("contiene")) {
            return dato.toLowerCase().contains(valor.toLowerCase());
        }

        int comparacion;

        if (campo.equals("id") || campo.equals("edad")) {
            try {
                comparacion = Integer.compare(
                    Integer.parseInt(dato),
                    Integer.parseInt(valor)
                );
            } catch (NumberFormatException ex) {
                return false;
            }
        } else {
            comparacion = dato.compareToIgnoreCase(valor);
        }

        switch (operador) {
            case "=":
                return comparacion == 0;
            case "!=":
                return comparacion != 0;
            case ">":
                return comparacion > 0;
            case "<":
                return comparacion < 0;
            case ">=":
                return comparacion >= 0;
            case "<=":
                return comparacion <= 0;
            default:
                return false;
        }
    }
}