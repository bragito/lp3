import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Curso> cursos;

    public SistemaGestion() {
        this.cursos = new ArrayList<>();
    }

    public void registrarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void listarCursosDisponibles() {
        System.out.println("\n--- CURSOS DISPONIBLES EN " + ConfigConstantes.INSTITUCION + " ---");
        for (Curso c : cursos) {
            c.mostrarDetalle();
        }
    }
}