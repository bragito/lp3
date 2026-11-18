package fase1.trabajo10.actividades.dos;


import javax.swing.*;
import java.awt.*;

public class GraficosSwing extends JFrame {

    public GraficosSwing() {
        setTitle("Gráficos Simples y Avanzados con Swing");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new PanelGraficos());
    }

    class PanelGraficos extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Título
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Ejemplos de gráficos en Java", 180, 30);

            // Rectángulo
            g2.setColor(Color.BLUE);
            g2.fillRect(50, 70, 120, 80);

            // Círculo
            g2.setColor(Color.RED);
            g2.fillOval(220, 70, 100, 100);

            // Línea
            g2.setColor(Color.GREEN);
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(380, 80, 520, 160);

            // Gráfico de barras
            g2.setColor(Color.BLACK);
            g2.drawString("Gráfico de barras", 50, 230);

            int[] valores = {80, 120, 50, 150, 100};
            Color[] colores = {
                Color.BLUE, Color.RED, Color.GREEN,
                Color.ORANGE, Color.MAGENTA
            };

            for (int i = 0; i < valores.length; i++) {
                g2.setColor(colores[i]);
                g2.fillRect(60 + i * 60,400 - valores[i], 50, valores[i]);

                g2.setColor(Color.BLACK);
                g2.drawString(String.valueOf(valores[i]),
                    70 + i * 60, 390 - valores[i]);
            }

            // Gráfico circular
            g2.setColor(Color.BLACK);
            g2.drawString("Gráfico circular", 470, 230);

            int[] porcentajes = {40, 30, 20, 10};
            Color[] sectores = {
                Color.BLUE, Color.RED,
                Color.GREEN, Color.ORANGE
            };

            int inicio = 0;

            for (int i = 0; i < porcentajes.length; i++) {
                g2.setColor(sectores[i]);

                int angulo = porcentajes[i] * 360 / 100;

                g2.fillArc(470, 250, 150, 150,
                    inicio, angulo);

                inicio += angulo;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new GraficosSwing().setVisible(true));
    }
}
