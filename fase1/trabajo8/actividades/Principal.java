package fase1.trabajo8.actividades;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:universidad.db";

        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection con =
                    DriverManager.getConnection(url)) {

                System.out.println("Conexion exitosa");

                // 1. Crear tabla
                Statement stmt = con.createStatement();

                stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS estudiantes (" +
                    "id INTEGER PRIMARY KEY, " +
                    "nombre TEXT, " +
                    "edad INTEGER)"
                );

                // 2. Iniciar transaccion
                con.setAutoCommit(false);

                try {
                    // 3. Insertar registros
                    PreparedStatement insertar =
                        con.prepareStatement(
                            "INSERT OR REPLACE INTO estudiantes " +
                            "(id, nombre, edad) VALUES (?, ?, ?)"
                        );

                    insertar.setInt(1, 1);
                    insertar.setString(2, "Carlos");
                    insertar.setInt(3, 20);
                    insertar.executeUpdate();

                    insertar.setInt(1, 2);
                    insertar.setString(2, "Maria");
                    insertar.setInt(3, 21);
                    insertar.executeUpdate();

                    System.out.println("Registros insertados");

                    // 4. Actualizar registro
                    PreparedStatement actualizar =
                        con.prepareStatement(
                            "UPDATE estudiantes SET edad = ? " +
                            "WHERE id = ?"
                        );

                    actualizar.setInt(1, 22);
                    actualizar.setInt(2, 1);
                    actualizar.executeUpdate();

                    System.out.println("Registro actualizado");

                    // 5. Eliminar registro
                    PreparedStatement eliminar =
                        con.prepareStatement(
                            "DELETE FROM estudiantes WHERE id = ?"
                        );

                    eliminar.setInt(1, 2);
                    eliminar.executeUpdate();

                    System.out.println("Registro eliminado");

                    // 6. Confirmar cambios
                    con.commit();
                    System.out.println("Transaccion confirmada");

                } catch (SQLException e) {
                    con.rollback();
                    System.out.println("Transaccion revertida");
                    System.out.println(e.getMessage());
                }

                // 7. Consultar registros
                PreparedStatement consultar =
                    con.prepareStatement(
                        "SELECT * FROM estudiantes"
                    );

                ResultSet rs = consultar.executeQuery();

                System.out.println("\nLISTA DE ESTUDIANTES");

                while (rs.next()) {
                    System.out.println(
                        "ID: " + rs.getInt("id") +
                        " | Nombre: " + rs.getString("nombre") +
                        " | Edad: " + rs.getInt("edad")
                    );
                }

                rs.close();
                consultar.close();
                stmt.close();

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
