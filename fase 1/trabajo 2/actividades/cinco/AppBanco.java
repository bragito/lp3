package actividades.cinco;
import java.util.Scanner;

public class AppBanco {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Crear las cuentas
        Cuenta[] cuentas = new Cuenta[4];

        cuentas[0] = new CuentaAhorro(
                1001,
                1000.0,
                "Juan",
                "Perez",
                0.02
        );

        cuentas[1] = new CuentaCorriente(
                1002,
                2000.0,
                "Maria",
                "Lopez"
        );

        cuentas[2] = new CuentaAhorro(
                1003,
                1500.0,
                "Pedro",
                "Garcia",
                0.015
        );

        cuentas[3] = new CuentaCorriente(
                1004,
                3000.0,
                "Ana",
                "Torres"
        );

        boolean done = false;

        while (!done) {

            System.out.print("D)epositar R)etirar C)onsultar S)alir: ");
            String op = in.next();

            if (op.equalsIgnoreCase("D") || op.equalsIgnoreCase("R")) {

                System.out.println("Ingrese el numero de cuenta: ");
                int num = in.nextInt();

                System.out.print("Ingrese el monto: ");
                double monto = in.nextDouble();
                num-=1001;
                if (op.equalsIgnoreCase("D")) {
                    cuentas[num].Despositar(monto);
                } else {
                    cuentas[num].Retirar(monto);
                }

                System.out.println("Saldo: " + cuentas[num].getSaldo());

            } else if (op.equalsIgnoreCase("C")) {

                for (int n = 0; n < cuentas.length; n++) {
                    cuentas[n].consulta();
                    System.out.println();
                }

            } else if (op.equalsIgnoreCase("S")) {

                done = true;
            }
        }

        in.close();
    }
}
