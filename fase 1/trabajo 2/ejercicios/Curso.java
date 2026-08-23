import java.util.ArrayList;
import java.util.List;

public class Curso {
    private static int totalCursosCreados = 0;

    private String codigo;
    private String nombre;
    private String categoria;
    private Profesor profesor;
    private List<Estudiante> estudiantesMatriculados;

    public Curso(String codigo, String nombre, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.estudiantesMatriculados = new ArrayList<>();
        totalCursosCreados++;
    }

    public static int getTotalCursosCreados() {
        return totalCursosCreados;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public boolean matricularEstudiante(Estudiante estudiante) {
        if (estudiantesMatriculados.size() < ConfigConstantes.MAX_ESTUDIANTES_POR_CURSO) {
            estudiantesMatriculados.add(estudiante);
            return true;
        }
        return false;
    }

    public int getCantidadEstudiantes() {
        return estudiantesMatriculados.size();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public Profesor getProfesor() { return profesor; }

    public void mostrarDetalle() {
        System.out.println("Curso: " + nombre + " [" + codigo + "] | Categoria: " + categoria);
        System.out.println("  Profesor: " + (profesor != null ? profesor.getNombre() : "Sin asignar"));
        System.out.println("  Inscriptos: " + estudiantesMatriculados.size() + "/" + ConfigConstantes.MAX_ESTUDIANTES_POR_CURSO);
        if (!estudiantesMatriculados.isEmpty()) {
            System.out.println("  Estudiantes Matriculados:");
            for (Estudiante e : estudiantesMatriculados) {
                System.out.println("    - " + e.getNombre() + " (" + e.getCarrera() + ")");
            }
        }
    }
}