import java.util.Scanner;

public class E6 {

    public static int convertirSegundos(int horas, int minutos, int segundos) {

        int total;

        total = horas * 3600 + minutos * 60 + segundos;

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese las horas: ");
        int horas = sc.nextInt();

        System.out.print("Ingrese los minutos: ");
        int minutos = sc.nextInt();

        System.out.print("Ingrese los segundos: ");
        int segundos = sc.nextInt();

        int total = convertirSegundos(horas, minutos, segundos);

        System.out.println("El equivalente en segundos es: " + total);

        sc.close();
    }
}