//El usuario ingresará números en un arreglo unidimensional de 10, 
// cada número que ingrese usuario debe ser mayor al anterior. 
// Guarde estos números en el arreglo
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[10];

        System.out.print("Ingrese el numero 1: ");
        numeros[0] = entrada.nextInt();

        for (int i = 1; i < numeros.length; i++) {

            do {
                System.out.print("Ingrese un numero mayor que "
                        + numeros[i - 1] + ": ");

                numeros[i] = entrada.nextInt();

                if (numeros[i] <= numeros[i - 1]) {
                    System.out.println("Error: debe ingresar un numero mayor.");
                }

            } while (numeros[i] <= numeros[i - 1]);
        }

        System.out.println("\nArreglo ingresado:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        entrada.close();
    }
}
