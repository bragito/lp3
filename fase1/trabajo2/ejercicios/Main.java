public class Main {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("P01", "MARIO CESAR SANTILLANA VALDIVIA", "Lenguajes de Programacion III");
        
        Estudiante est1 = new Estudiante("E01", "Arcos Chuima, Alexander Daniel", "Ingenieria de Sistemas");
        Estudiante est2 = new Estudiante("E02", "Salazar Aguirre, Edwin David", "Ingenieria de Sistemas");

        est1.agregarNota(17.5);
        est1.agregarNota(18.0);

        est2.agregarNota(16.0);
        est2.agregarNota(19.0);

        Curso cursoJava = new Curso("IS301", "Lenguajes de Programacion III", "Ingenieria de Sistemas");

        cursoJava.asignarProfesor(prof1);
        cursoJava.matricularEstudiante(est1);
        cursoJava.matricularEstudiante(est2);

        SistemaGestion sistema = new SistemaGestion();
        sistema.registrarCurso(cursoJava);

        System.out.println("--- DEMOSTRACION DE POLIMORFISMO ---");
        Persona[] personas = { prof1, est1, est2 };
        for (Persona p : personas) {
            p.mostrarInformacion();
        }

        System.out.println("\nPromedio de " + est1.getNombre() + ": " + est1.calcularPromedio());
        System.out.println("Promedio de " + est2.getNombre() + ": " + est2.calcularPromedio());

        sistema.listarCursosDisponibles();

        System.out.println("\nTotal de cursos registrados en el sistema: " + Curso.getTotalCursosCreados());
    }
}