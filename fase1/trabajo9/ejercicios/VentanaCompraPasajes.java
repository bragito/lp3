package fase1.trabajo9.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCompraPasajes extends JFrame {

    // Componentes de la GUI
    private JTextField txtNombres, txtDocumento, txtFecha;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private ButtonGroup grupoPiso;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JComboBox<String> cmbOrigen, cmbDestino;
    private JList<String> listServicio;
    private JButton btnComprar, btnLimpiar;

    public VentanaCompraPasajes() {
        // Título de la ventana (puedes cambiar los nombres de los integrantes aquí)
        super("Compra de Pasajes - Grupo Nectar");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel principal con diseño en cuadrícula para los campos de entrada
        JPanel panelCentral = new JPanel(new GridLayout(8, 2, 8, 8));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // 1. Nombres
        panelCentral.add(new JLabel("Nombres y Apellidos:"));
        txtNombres = new JTextField(20);
        panelCentral.add(txtNombres);

        // 2. Documento de Identidad
        panelCentral.add(new JLabel("Documento de Identidad:"));
        txtDocumento = new JTextField(15);
        panelCentral.add(txtDocumento);

        // 3. Fecha de Viaje
        panelCentral.add(new JLabel("Fecha de Viaje (DD/MM/AAAA):"));
        txtFecha = new JTextField(10);
        panelCentral.add(txtFecha);

        // 4. Origen y Destino (Cuadros combinados)
        panelCentral.add(new JLabel("Lugar de Origen:"));
        String[] ciudades = {"Arequipa", "Lima", "Cusco", "Puno", "Tacna", "Trujillo"};
        cmbOrigen = new JComboBox<>(ciudades);
        panelCentral.add(cmbOrigen);

        panelCentral.add(new JLabel("Lugar de Destino:"));
        cmbDestino = new JComboBox<>(ciudades);
        panelCentral.add(cmbDestino);

        // 5. Botones de Opción (Piso del bus)
        panelCentral.add(new JLabel("Ubicación en el Bus:"));
        JPanel panelPiso = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbPrimerPiso = new JRadioButton("1er Piso", true);
        rbSegundoPiso = new JRadioButton("2do Piso");
        grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        panelCentral.add(panelPiso);

        // 6. Casillas de Verificación (Servicios opcionales)
        panelCentral.add(new JLabel("Servicios Opcionales:"));
        JPanel panelOpcionales = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        panelOpcionales.add(chkAudifonos);
        panelOpcionales.add(chkManta);
        panelOpcionales.add(panelOpcionales.add(chkRevistas)); // Nota: corregido abajo en el panel inferior
        panelCentral.add(panelOpcionales);

        // 7. Lista (Calidad de servicio)
        panelCentral.add(new JLabel("Calidad de Servicio:"));
        String[] calidades = {"Económico", "Standard", "VIP"};
        listServicio = new JList<>(calidades);
        listServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listServicio.setSelectedIndex(0);
        JScrollPane scrollLista = new JScrollPane(listServicio);
        panelCentral.add(scrollLista);

        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior para los Botones de Comando
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnComprar = new JButton("Mostrar Resumen de Compra");
        btnLimpiar = new JButton("Reiniciar / Blanquear");
        
        panelBotones.add(btnComprar);
        panelBotones.add(btnLimpiar);
        add(panelBotones, BorderLayout.SOUTH);

        // --- ACCIONES DE LOS BOTONES ---

        // Botón para mostrar el resumen en un cuadro de diálogo
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validación básica de campos vacíos
                if (txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaCompraPasajes.this,
                            "Por favor, complete los campos obligatorios (Nombres y Documento).",
                            "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Recopilar datos
                String nombres = txtNombres.getText();
                String documento = txtDocumento.getText();
                String fecha = txtFecha.getText();
                String origen = (String) cmbOrigen.getSelectedItem();
                String destino = (String) cmbDestino.getSelectedItem();
                
                String piso = rbPrimerPiso.isSelected() ? "1er Piso" : "2do Piso";
                
                String opcionales = "";
                if (chkAudifonos.isSelected()) opcionales += "- Audífonos\n";
                if (chkManta.isSelected()) opcionales += "- Manta\n";
                if (chkRevistas.isSelected()) opcionales += "- Revistas\n";
                if (opcionales.isEmpty()) opcionales = "Ninguno";

                String calidadServicio = listServicio.getSelectedValue();

                // Construir mensaje de resumen
                String resumen = "=== RESUMEN DE COMPRA DE PASAJE ===\n" +
                        "• Pasajero: " + nombres + "\n" +
                        "• Documento: " + documento + "\n" +
                        "• Fecha de Viaje: " + fecha + "\n" +
                        "• Ruta: " + origen + " ➔ " + destino + "\n" +
                        "• Ubicación: " + piso + "\n" +
                        "• Calidad de Servicio: " + calidadServicio + "\n" +
                        "• Servicios Opcionales:\n" + opcionales;

                // Mostrar en cuadro de diálogo (JOptionPane)
                JOptionPane.showMessageDialog(VentanaCompraPasajes.this,
                        resumen, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botón para reiniciar o blanquear todos los componentes
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombres.setText("");
                txtDocumento.setText("");
                txtFecha.setText("");
                cmbOrigen.setSelectedIndex(0);
                cmbDestino.setSelectedIndex(0);
                rbPrimerPiso.setSelected(true);
                chkAudifonos.setSelected(false);
                chkManta.setSelected(false);
                chkRevistas.setSelected(false);
                listServicio.setSelectedIndex(0);
                txtNombres.requestFocus();
            }
        });
    }
}