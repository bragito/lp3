import java.util.Random;

public class E3 {
    public static void main(String[] args) {

        Random aleatorio = new Random();

        int[] frecuencia = new int[6];

        for (int i = 0; i < 20000; i++) {

            int dado = aleatorio.nextInt(6) + 1;

            frecuencia[dado - 1]++;
        }

        System.out.println("Frecuencia de cada cara:");

        for (int i = 0; i < frecuencia.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i]);
        }
    }
}