package fase1.trabajo10.ejercicios;

import javax.swing.*;
import java.awt.*;

public class GestionProductos {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame f = new JFrame("Ejercicio 1 - Gestión de productos");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));

            JTextField nombre = new JTextField("Cuaderno");
            JTextField precio = new JTextField("8.50");
            JTextField stock = new JTextField("15");
            JTextField categoria = new JTextField("Útiles");

            form.add(new JLabel("Nombre"));
            form.add(nombre);
            form.add(new JLabel("Precio"));
            form.add(precio);
            form.add(new JLabel("Cantidad en stock"));
            form.add(stock);
            form.add(new JLabel("Categoría"));
            form.add(categoria);

            JButton actualizar = new JButton("Actualizar Producto");
            JLabel salida = new JLabel("Ingresa datos y actualiza");

            form.add(actualizar);
            form.add(new JLabel(""));

            Producto producto = new Producto("Cuaderno", 8.5, 15, "Útiles");

            actualizar.addActionListener(e -> {
                try {
                    String n = nombre.getText().trim(),
                           c = categoria.getText().trim();

                    if (n.isEmpty() || c.isEmpty())
                        throw new IllegalArgumentException("Nombre y categoría obligatorios");

                    double pr = Double.parseDouble(precio.getText().trim());
                    int st = Integer.parseInt(stock.getText().trim());

                    if (!Double.isFinite(pr) || pr < 0 || st < 0)
                        throw new IllegalArgumentException("Precio y stock deben ser no negativos");

                    producto.setNombre(n);
                    producto.setPrecio(pr);
                    producto.setCantidadStock(st);
                    producto.setCategoria(c);

                    salida.setText(producto.toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f, "Datos inválidos: " + ex.getMessage());
                }
            });

            f.add(form, BorderLayout.CENTER);
            f.add(salida, BorderLayout.SOUTH);
            f.setSize(680, 270);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        });
    }
}