package fase1.trabajo9.ejercicios;

import javax.swing.SwingUtilities;

public class MainCompra {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaCompraPasajes ventana = new VentanaCompraPasajes();
            ventana.setVisible(true);
        });
    }
}