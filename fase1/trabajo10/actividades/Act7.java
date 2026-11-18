package fase1.trabajo10.actividades;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.io.File;

public class Act7 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Reproducción de Video");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel);

        frame.setVisible(true);

        Platform.runLater(() -> {

            String videoPath = new File("C:\\Users\\alexa\\Videos\\Grabaciones de pantalla\\Grabación de pantalla 2026-11-17 102428.mp4").toURI().toString();

            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            mediaView.setFitWidth(800);
            mediaView.setFitHeight(600);
            mediaView.setPreserveRatio(true);

            Group root = new Group(mediaView);
            Scene scene = new Scene(root, 800, 600);

            jfxPanel.setScene(scene);

            mediaPlayer.play();
        });
    }
}