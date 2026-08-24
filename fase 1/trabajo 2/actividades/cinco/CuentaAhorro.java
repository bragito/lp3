package actividades.cinco;

public class CuentaAhorro extends Cuenta {

    private double tasaInteres;
    private double saldoMinimoMensual;

    public CuentaAhorro(int id, double saldo, String nombre, String apellidos,
                        double tasaInteres) {
        super(id, saldo, nombre, apellidos);
        this.tasaInteres = tasaInteres;
        this.saldoMinimoMensual = saldo;
    }

    public void setTasaInteres(double tasa) {
        this.tasaInteres = tasa;
    }

    public void retirar(double monto) {
        if (monto < 0 || monto > getSaldo()) {
            System.out.println("Accion no disponible");
        } else {
            saldo -= monto;
            actualizarSaldoMinimo();
            System.out.println("Retiro exitoso");
        }
    }

    public void actualizarSaldoMinimo() {
        if (saldo < saldoMinimoMensual) {
            saldoMinimoMensual = saldo;
        }
    }

    public void capitalizarIntereses() {
        double intereses = saldoMinimoMensual * tasaInteres;
        saldo += intereses;

        saldoMinimoMensual = saldo;
    }

    @Override
    public void consulta() {
        System.out.println("=== CUENTA DE AHORRO ===");
        System.out.println("Saldo: S/. " + getSaldo());
        System.out.println("Tasa de interes: " + tasaInteres);
        System.out.println("Saldo minimo mensual: S/. " + saldoMinimoMensual);
    }
}
