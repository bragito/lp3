package fase1.trabajo10.ejercicios;


import javax.sound.sampled.*;
import java.io.*;

public class AudioUtil {

    public static Clip cargar(String ruta) throws Exception {
        File archivo = new File(ruta);

        try (AudioInputStream in = AudioSystem.getAudioInputStream(archivo)) {
            Clip c = AudioSystem.getClip();
            c.open(in);
            return c;
        }
    }
}