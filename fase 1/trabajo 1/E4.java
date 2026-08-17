public class E4 {

    public static double menor(double num1, double num2, double num3) {

        double menor = num1;

        if (num2 < menor) {
            menor = num2;
        }

        if (num3 < menor) {
            menor = num3;
        }

        return menor;
    }

    public static void main(String[] args) {

        double resultado = menor(8.5, 3.2, 6.7);

        System.out.println("El menor es: " + resultado);
    }
}