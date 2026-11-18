package fase1.trabajo10.actividades.dos;


import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MultimediaSwing extends JFrame {

    private Clip clip;

    public MultimediaSwing() {
        setTitle("Aplicación Multimedia con Swing");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titulo = new JLabel(
            "REPRODUCTOR MULTIMEDIA",
            SwingConstants.CENTER
        );

        JButton btnAbrir = new JButton("Abrir audio");
        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnDetener = new JButton("Detener");

        panel.add(titulo);
        panel.add(btnAbrir);
        panel.add(btnReproducir);
        panel.add(btnPausar);
        panel.add(btnDetener);

        add(panel);

        btnAbrir.addActionListener(e -> abrirAudio());

        btnReproducir.addActionListener(e -> {
            if (clip != null) {
                clip.start();
            }
        });

        btnPausar.addActionListener(e -> {
            if (clip != null) {
                clip.stop();
            }
        });

        btnDetener.addActionListener(e -> {
            if (clip != null) {
                clip.stop();
                clip.setFramePosition(0);
            }
        });
    }

    private void abrirAudio() {
        JFileChooser selector = new JFileChooser();

        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                if (clip != null) {
                    clip.close();
                }

                File archivo = selector.getSelectedFile();

                AudioInputStream audio =
                    AudioSystem.getAudioInputStream(archivo);

                clip = AudioSystem.getClip();
                clip.open(audio);

                JOptionPane.showMessageDialog(this,
                    "Audio cargado correctamente");

            } catch (UnsupportedAudioFileException |
                     IOException |
                     LineUnavailableException ex) {

                JOptionPane.showMessageDialog(this,
                    "Error al cargar el audio: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new MultimediaSwing().setVisible(true));
    }
}
