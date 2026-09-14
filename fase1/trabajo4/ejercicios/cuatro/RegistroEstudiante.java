package fase1.trabajo4.ejercicios.cuatro;
import java.util.NoSuchElementException;

public class RegistroEstudiante implements Registro {

    private Estudiante[] estudiantes;
    private int cantidad;

    public RegistroEstudiante(int capacidad) {

        if (capacidad <= 0) {
            throw new IllegalArgumentException(
                "La capacidad debe ser mayor a 0"
            );
        }

        estudiantes = new Estudiante[capacidad];
        cantidad = 0;
    }

    @Override
    public void agregarEstudiante(Estudiante estudiante) {

        if (estudiante == null) {
            throw new IllegalArgumentException(
                "El estudiante no puede ser nulo"
            );
        }

        if (cantidad >= estudiantes.length) {
            throw new IllegalArgumentException(
                "No hay espacio para más estudiantes."
            );
        }

        estudiantes[cantidad] = estudiante;
        cantidad++;
    }

    @Override
    public Estudiante buscarEstudiante(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre de búsqueda no puede ser nulo o vacío."
            );
        }

        for (int i = 0; i < cantidad; i++) {

            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return estudiantes[i];
            }
        }

        throw new NoSuchElementException(
            "El estudiante no se encuentra en el registro."
        );
    }
}
