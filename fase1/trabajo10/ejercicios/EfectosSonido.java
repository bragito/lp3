package fase1.trabajo10.ejercicios;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;

public class EfectosSonido {

    private static Clip actual;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame f = new JFrame("Ejercicio 3 - Efectos de sonido");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new GridLayout(1, 3, 12, 12));

            String[] nombres = {"Aplausos", "Campana", "Explosión"};

            String[] archivos = {
                "C:\\Users\\alexa\\Music\\Pelon-Aplaudiendo-_-_RE-cqMrcl-k_.wav",
                "C:\\Users\\alexa\\Music\\Bell-meme-sound-effect-_dtx8Yq9OlK0_.wav",
                "C:\\Users\\alexa\\OneDrive\\Documentos\\lp3-main\\fase1\\trabajo10\\ejercicios\\___-_______-__________-_______-___-____ñ___.wav"
            };

            for (int i = 0; i < 3; i++) {

                final String ruta = archivos[i];

                JButton b = new JButton(nombres[i]);

                b.addActionListener(e -> {
                    try {
                        if (actual != null) {
                            actual.stop();
                            actual.close();
                        }

                        // Comprobar si existe el archivo
                        File archivo = new File(ruta);

                        if (!archivo.exists()) {
                            JOptionPane.showMessageDialog(
                                f, "No existe el archivo:\n" + ruta
                            );
                            return;
                        }

                        actual = AudioUtil.cargar(ruta);
                        actual.start();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(
                            f,
                            "No se pudo reproducir:\n" + ex.getMessage()
                        );
                    }
                });

                f.add(b);
            }

            f.setSize(530, 160);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
