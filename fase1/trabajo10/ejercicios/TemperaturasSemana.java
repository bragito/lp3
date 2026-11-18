
package fase1.trabajo10.ejercicios;

import javax.swing.*;
import java.awt.*;

public class TemperaturasSemana extends JPanel {

    private double[] valores = {18, 19, 21, 20, 22, 23, 19};

    private final String[] dias = {
        "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D a = (Graphics2D) g.create();

        a.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int w = getWidth();
        int h = getHeight();

        int left = 65;
        int right = 30;
        int top = 35;
        int bottom = 60;

        double min = -10;
        double max = 50;

        int y0 = h - bottom;

        // Dibujar ejes
        a.setColor(Color.DARK_GRAY);
        a.drawLine(left, top, left, y0);
        a.drawLine(left, y0, w - right, y0);

        // Dibujar líneas horizontales y temperaturas
        for (int t = -10; t <= 50; t += 10) {

            int y = y0 - (int) (
                (t - min) / (max - min) * (y0 - top)
            );

            a.setColor(new Color(225, 225, 225));
            a.drawLine(left, y, w - right, y);

            a.setColor(Color.BLACK);
            a.drawString(t + " °C", 10, y + 5);
        }

        // Dibujar gráfico
        a.setColor(new Color(25, 110, 190));
        a.setStroke(new BasicStroke(3));

        int px = -1;
        int py = -1;

        for (int i = 0; i < 7; i++) {

            int x = left + i * (w - left - right) / 6;

            int y = y0 - (int) (
                (valores[i] - min) / (max - min) * (y0 - top)
            );

            // Unir puntos
            if (px >= 0) {
                a.drawLine(px, py, x, y);
            }

            // Dibujar punto
            a.fillOval(x - 5, y - 5, 10, 10);

            // Mostrar día
            a.setColor(Color.BLACK);
            a.drawString(dias[i], x - 12, y0 + 20);

            // Mostrar temperatura
            a.drawString(
                String.format("%.1f °C", valores[i]),
                x - 20,
                y - 12
            );

            a.setColor(new Color(25, 110, 190));

            px = x;
            py = y;
        }

        a.dispose();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame f = new JFrame(
                "Ejercicio 2 - Temperaturas semanales"
            );

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            TemperaturasSemana chart = new TemperaturasSemana();

            // Panel para ingresar temperaturas
            JPanel controls = new JPanel(
                new GridLayout(2, 7, 4, 4)
            );

            JTextField[] campos = new JTextField[7];

            // Etiquetas de los días
            for (int i = 0; i < 7; i++) {
                controls.add(
                    new JLabel(chart.dias[i], SwingConstants.CENTER)
                );
            }

            // Campos de temperaturas
            for (int i = 0; i < 7; i++) {

                campos[i] = new JTextField(
                    String.valueOf(chart.valores[i])
                );

                controls.add(campos[i]);
            }

            // Botón para mostrar gráfico
            JButton boton = new JButton("Mostrar Gráfico");

            boton.addActionListener(e -> {

                try {

                    double[] nuevos = new double[7];

                    for (int i = 0; i < 7; i++) {

                        nuevos[i] = Double.parseDouble(
                            campos[i].getText().trim()
                        );

                        if (!Double.isFinite(nuevos[i])
                                || nuevos[i] < -10
                                || nuevos[i] > 50) {

                            throw new IllegalArgumentException(
                                "Rango permitido: -10 a 50 °C"
                            );
                        }
                    }

                    chart.valores = nuevos;
                    chart.repaint();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                        f,
                        "Revisa las temperaturas. " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            // Panel superior
            JPanel arriba = new JPanel(new BorderLayout());

            arriba.add(controls, BorderLayout.CENTER);
            arriba.add(boton, BorderLayout.SOUTH);

            f.add(arriba, BorderLayout.NORTH);
            f.add(chart, BorderLayout.CENTER);

            f.setSize(750, 490);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
