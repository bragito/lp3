package lp3.fase1.trabajo3.ejercicios.uno;

public class CalcularPago {

    private static final int HORAS_MENSUALES = 240;

    public double calcularPago(Empleado empleado, int horasTrabajadas) {

        double pagoPorHora = empleado.getSalario();

        if (horasTrabajadas == HORAS_MENSUALES) {
            System.out.println("Horas trabajadas completas");
        }

        return pagoPorHora * horasTrabajadas;
    }
}
