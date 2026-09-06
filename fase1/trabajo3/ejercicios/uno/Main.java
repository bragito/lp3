package lp3.fase1.trabajo3.ejercicios.uno;

public class Main {

    public static void main(String[] args) {

        Empleado emp = new Empleado("Juan", 20, "Ventas");

        System.out.println(emp);

        CalcularPago calculadora = new CalcularPago();

        double pago = calculadora.calcularPago(emp, 180);

        System.out.println("Pago: " + pago);
    }
}
