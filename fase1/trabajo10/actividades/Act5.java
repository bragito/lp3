package fase1.trabajo10.actividades;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Act5 {

    public static void main(String[] args) {

        try {
            File audioFile = new File("C:\\Users\\alexa\\Music\\California Ciclope.wav"
);
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);

            clip.start();

        } catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException e) {

            e.printStackTrace();
        }
    }
}