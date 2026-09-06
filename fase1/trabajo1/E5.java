import java.util.Scanner;
public class E5 {

    public static double calcularCargo(int horas) {

        double cargo;

        if (horas <= 1) {
            cargo = 3.00;
        } else {
            cargo = 3.00 + (horas - 1) * 0.50;
        }

        if (cargo > 12.00) {
            cargo = 12.00;
        }

        return cargo;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("ingrese las horas");
        int horas=sc.nextInt();
        double cargo = calcularCargo(horas);

        System.out.println("Horas: " + horas);
        System.out.println("Cargo: S/ " + cargo);
        sc.close();
    }
} 
    

