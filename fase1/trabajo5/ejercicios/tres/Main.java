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

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }
}

public class Main {

    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 18);
        Par<Double, Boolean> par2 = new Par<>(15.5, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Andree"), 20);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
