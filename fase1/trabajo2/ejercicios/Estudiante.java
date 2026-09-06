import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements Evaluable {
    private String carrera;
    private List<Double> notas;

    public Estudiante(String id, String nombre, String carrera) {
        super(id, nombre);
        this.carrera = carrera;
        this.notas = new ArrayList<>();
    }

    public String getCarrera() {
        return carrera;
    }

    public void agregarNota(double nota) {
        this.notas.add(nota);
    }

    @Override
    public String obtenerRol() {
        return "Estudiante de " + carrera;
    }

    @Override
    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }
}