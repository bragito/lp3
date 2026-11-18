package fase1.trabajo10.actividades.dos;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BindingDatos extends JFrame {

    private JTextField txtNombre, txtEdad, txtCorreo;
    private JTable tabla;
    private DefaultTableModel modelo;

    public BindingDatos() {
        setTitle("Binding de Datos Manual con Swing");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        panel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnLimpiar = new JButton("Limpiar");

        panel.add(btnGuardar);
        panel.add(btnLimpiar);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Correo");

        tabla = new JTable(modelo);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnGuardar.addActionListener(e -> guardarDatos());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void guardarDatos() {
        String nombre = txtNombre.getText();
        String edad = txtEdad.getText();
        String correo = txtCorreo.getText();

        if (nombre.isEmpty() || edad.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Complete todos los campos");
            return;
        }

        try {
            Integer.parseInt(edad);

            modelo.addRow(new Object[]{
                nombre, edad, correo
            });

            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "La edad debe ser un número");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new BindingDatos().setVisible(true));
    }
}

