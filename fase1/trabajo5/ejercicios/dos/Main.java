package fase1.trabajo5.ejercicios.dos;

public class Main {
    public static void main(String[] args) {
        genericoPar<String, Integer> par1 = new genericoPar<>("Juan", 20);
        genericoPar<String, Integer> par2 = new genericoPar<>("Juan", 20);
        genericoPar<String, Integer> par3 = new genericoPar<>("Pedro", 20);
        genericoPar<String, Integer> par4 = new genericoPar<>("Juan", 30);

        System.out.println("Par 1: " + par1);
        System.out.println("Par 2: " + par2);
        System.out.println("Par 3: " + par3);
        System.out.println("Par 4: " + par4);

        System.out.println();

        System.out.println("¿Par 1 es igual a Par 2? " + par1.esIgual(par2));
        System.out.println("¿Par 1 es igual a Par 3? " + par1.esIgual(par3));
        System.out.println("¿Par 1 es igual a Par 4? " + par1.esIgual(par4));
    }
}
