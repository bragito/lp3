package fase1.trabajo10.ejercicios;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMusica {

    private Clip clip;
    private long pausa;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorMusica().mostrar());
    }

    private void mostrar() {

        JFrame f = new JFrame("Ejercicio 4 - Reproductor de música");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new FlowLayout());

        JButton reproducir = new JButton("Reproducir");
        JButton pausar = new JButton("Pausar");
        JButton reanudar = new JButton("Reanudar");

        p.add(reproducir);
        p.add(pausar);
        p.add(reanudar);

        // Botón reproducir
        reproducir.addActionListener(e -> {

            try {

                if (clip != null) {
                    clip.close();
                }

                File archivo = new File("C:\\Users\\alexa\\OneDrive\\Documentos\\lp3-main\\fase1\\trabajo10\\ejercicios\\___-_______-__________-_______-___-____ñ___.wav");

                AudioInputStream audio =
                    AudioSystem.getAudioInputStream(archivo);

                clip = AudioSystem.getClip();
                clip.open(audio);

                pausa = 0;
                clip.setMicrosecondPosition(0);
                clip.start();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                    f,
                    "Error de audio: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // Botón pausar
        pausar.addActionListener(e -> {

            if (clip != null && clip.isRunning()) {

                pausa = clip.getMicrosecondPosition();
                clip.stop();
            }
        });

        // Botón reanudar
        reanudar.addActionListener(e -> {

            if (clip != null && !clip.isRunning()) {

                if (pausa >= clip.getMicrosecondLength()) {
                    pausa = 0;
                }

                clip.setMicrosecondPosition(pausa);
                clip.start();
            }
        });

        f.add(p);
        f.setSize(450, 140);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
