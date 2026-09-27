import java.util.ArrayList;

class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public String toString() {
        return "(" + primero + ", " + segundo + ")";
    }
}

class Contenedor<F, S> {
    private ArrayList<Par<F, S>> pares;

    public Contenedor() {
        pares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        pares.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        return pares.get(indice);
    }

    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    public void mostrarPares() {
        for (Par<F, S> par : pares) {
            System.out.println(par);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        contenedor.agregarPar("Matematica", 15);
        contenedor.agregarPar("Programacion", 18);
        contenedor.agregarPar("Redes", 17);

        contenedor.mostrarPares();

        System.out.println(contenedor.obtenerPar(1));
        System.out.println(contenedor.obtenerTodosLosPares());
    }
}
