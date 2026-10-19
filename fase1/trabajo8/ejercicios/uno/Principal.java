package fase1.trabajo8.ejercicios.uno;

import java.sql.*;
import java.util.Scanner;
 
public class Principal {
 
    static Scanner sc = new Scanner(System.in);
    static final String CLAVE = "1234";
 
    public static void main(String[] args) {
 
        try {
            Class.forName("org.sqlite.JDBC");
 
            Connection con = DriverManager.getConnection(
                "jdbc:sqlite:universidad.db"
            );
 
            Statement stmt = con.createStatement();
 
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS estudiantes (" +
                "id INTEGER PRIMARY KEY, " +
                "nombre TEXT, " +
                "edad INTEGER, " +
                "carrera TEXT)"
            );
 
            int opcion;
 
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Ingresar estudiante");
                System.out.println("2. Actualizar estudiante");
                System.out.println("3. Eliminar estudiante");
                System.out.println("4. Mostrar estudiantes");
                System.out.println("5. Salir");
                System.out.print("Seleccione: ");
 
                opcion = Integer.parseInt(sc.nextLine());
 
                switch (opcion) {
                    case 1:
                        ingresar(con);
                        break;
                    case 2:
                        actualizar(con);
                        break;
                    case 3:
                        eliminar(con);
                        break;
                    case 4:
                        mostrar(con);
                        break;
                    case 5:
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
 
            } while (opcion != 5);
 
            stmt.close();
            con.close();
 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    static void ingresar(Connection con) throws SQLException {
 
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
 
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
 
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
 
        System.out.print("Carrera: ");
        String carrera = sc.nextLine();
 
        con.setAutoCommit(false);
 
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO estudiantes VALUES (?, ?, ?, ?)"
            );
 
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, edad);
            ps.setString(4, carrera);
            ps.executeUpdate();
            ps.close();
 
            confirmar(con);
 
        } catch (SQLException e) {
            con.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            con.setAutoCommit(true);
        }
    }
 
    static void actualizar(Connection con) throws SQLException {
 
        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());
 
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
 
        System.out.print("Nueva edad: ");
        int edad = Integer.parseInt(sc.nextLine());
 
        System.out.print("Nueva carrera: ");
        String carrera = sc.nextLine();
 
        con.setAutoCommit(false);
 
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE estudiantes SET nombre=?, edad=?, " +
                "carrera=? WHERE id=?"
            );
 
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, carrera);
            ps.setInt(4, id);
 
            int filas = ps.executeUpdate();
            ps.close();
 
            if (filas == 0) {
                System.out.println("Estudiante no encontrado");
                con.rollback();
            } else {
                confirmar(con);
            }
 
        } catch (SQLException e) {
            con.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            con.setAutoCommit(true);
        }
    }
 
    static void eliminar(Connection con) throws SQLException {
 
        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
 
        con.setAutoCommit(false);
 
        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM estudiantes WHERE id=?"
            );
 
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            ps.close();
 
            if (filas == 0) {
                System.out.println("Estudiante no encontrado");
                con.rollback();
            } else {
                confirmar(con);
            }
 
        } catch (SQLException e) {
            con.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            con.setAutoCommit(true);
        }
    }
 
    static void mostrar(Connection con) throws SQLException {
 
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM estudiantes"
        );
 
        ResultSet rs = ps.executeQuery();
 
        System.out.println("\n===== ESTUDIANTES =====");
 
        while (rs.next()) {
            System.out.println(
                "ID: " + rs.getInt("id") +
                " | Nombre: " + rs.getString("nombre") +
                " | Edad: " + rs.getInt("edad") +
                " | Carrera: " + rs.getString("carrera")
            );
        }
 
        rs.close();
        ps.close();
    }
 
    static void confirmar(Connection con) throws SQLException {
 
        System.out.print("Ingrese clave de confirmacion: ");
        String clave = sc.nextLine();
 
        if (clave.equals(CLAVE)) {
            con.commit();
            System.out.println("Cambios guardados correctamente");
        } else {
            con.rollback();
            System.out.println("Clave incorrecta. Cambios revertidos");
        }
    }
}
