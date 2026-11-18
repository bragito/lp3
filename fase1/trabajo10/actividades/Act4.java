package fase1.trabajo10.actividades;

import javax.swing.*;
import java.awt.*;


public class Act4 extends JPanel {

    String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D"};
    int[] ventas = {50, 120, 80, 150};

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D d = (Graphics2D) g.create();
        d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int max = 150, base = getHeight() - 65;

        d.setColor(Color.BLACK);
        d.drawLine(45, 40, 45, base);
        d.drawString("Ventas", 5, 35);

        for (int i = 0; i < 4; i++) {
            int x = 55 + i * 90;
            int h = (int) (ventas[i] / (double) max * 220);

            d.setColor(new Color(90, 150, 205));
            d.fillRect(x, base - h, 55, h);

            d.setColor(Color.BLACK);
            d.drawString("" + ventas[i], x + 15, base - h - 5);
            d.drawString(productos[i], x - 7, base + 20);
        }

        d.dispose();
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Ejemplo - Gráfico de barras");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new Act4());
            f.setSize(450, 400);
            f.setVisible(true);
        });
    }
}
