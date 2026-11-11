package fase1.trabajo9.actividad.extra.JCheckBox;

// Fig. 12.17: MarcoCasillaVerificacion.java
// Botones JCheckBox y eventos de elementos con opciones ampliadas.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class MarcoCasillaVerificacion extends JFrame
{
    private final JTextField campoTexto; // muestra el texto en tipos de letra cambiantes
    private final JCheckBox negritaJCheckBox; // para seleccionar/deseleccionar negrita
    private final JCheckBox cursivaJCheckBox; // para seleccionar/deseleccionar cursiva
    private final JCheckBox tamanioJCheckBox; // para cambiar el tamaño del texto
    private final JButton botonRestablecer; // botón para restablecer la configuración

    // El constructor de MarcoCasillaVerificacion agrega objetos JCheckBox y botones a JFrame
    public MarcoCasillaVerificacion()
    {
        super("Prueba de JCheckBox Ampliada");
        setLayout(new FlowLayout());

        // establece JTextField y su tipo de letra
        campoTexto = new JTextField(" Observe como cambia el estilo de tipo de letra", 22);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto); // agrega campoTexto a JFrame

        negritaJCheckBox = new JCheckBox("Negrita");
        cursivaJCheckBox = new JCheckBox("Cursiva");
        tamanioJCheckBox = new JCheckBox("Tamaño Grande");
        
        add(negritaJCheckBox); // agrega casilla de verificación "negrita" a JFrame
        add(cursivaJCheckBox); // agrega casilla de verificación "cursiva" a JFrame
        add(tamanioJCheckBox); // agrega casilla de verificación "tamaño grande" a JFrame

        botonRestablecer = new JButton("Restablecer");
        add(botonRestablecer); // agrega el botón de restablecer

        // registra componentes de escucha para objetos JCheckBox
        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negritaJCheckBox.addItemListener(manejador);
        cursivaJCheckBox.addItemListener(manejador);
        tamanioJCheckBox.addItemListener(manejador);

        // acción para el botón restablecer
        botonRestablecer.addActionListener(e -> {
            negritaJCheckBox.setSelected(false);
            cursivaJCheckBox.setSelected(false);
            tamanioJCheckBox.setSelected(false);
            campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        });
    }

    // clase interna privada para el manejo de eventos ItemListener
    private class ManejadorCheckBox implements ItemListener
    {
        // responde a los eventos de casilla de verificación
        @Override
        public void itemStateChanged(ItemEvent evento)
        {
            int estilo = Font.PLAIN;
            int tamanio = 14; // Tamaño predeterminado

            if (negritaJCheckBox.isSelected())
                estilo += Font.BOLD;
            if (cursivaJCheckBox.isSelected())
                estilo += Font.ITALIC;

            // Si la casilla de tamaño grande está seleccionada, aumentamos a 20
            if (tamanioJCheckBox.isSelected())
                tamanio = 20;

            campoTexto.setFont(new Font("Serif", estilo, tamanio));
        }
    }
} // fin de la clase MarcoCasillaVerificacion
