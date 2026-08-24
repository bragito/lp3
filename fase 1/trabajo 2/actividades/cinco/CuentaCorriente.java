package actividades.cinco;

public class CuentaCorriente extends Cuenta {

    private int retirosMes;
    private static final int RETIROS_GRATUITOS = 3;
    private static final double TARIFA_RETIRO = 3.0;

    public CuentaCorriente(int id, double saldo, String nombre, String apellidos) {
        super(id, saldo, nombre, apellidos);
        this.retirosMes = 0;
    }

    @Override
    public void retirar(double monto) {

        if (monto < 0) {
            System.out.println("No se puede retirar un monto negativo");
            return;
        }

        double costo = 0;

        if (retirosMes >= RETIROS_GRATUITOS) {
            costo = TARIFA_RETIRO;
        }

        if (monto + costo > getSaldo()) {
            System.out.println("Saldo insuficiente");
            return;
        }

        saldo -= monto + costo;
        retirosMes++;

        System.out.println("Retiro exitoso");
    }

    @Override
    public void consulta() {
        System.out.println("=== CUENTA CORRIENTE ===");
        System.out.println("Saldo disponible: S/. " + getSaldo());
        System.out.println("Retiros realizados este mes: " + retirosMes);
        System.out.println("Retiros gratuitos restantes: "
                + Math.max(0, RETIROS_GRATUITOS - retirosMes));
    }
}
