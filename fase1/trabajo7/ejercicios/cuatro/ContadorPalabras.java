package fase1.trabajo7.ejercicios.cuatro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class ContadorPalabras {
    public static void main(String[] args) {

        JFileChooser selector = new JFileChooser();

        while (true) {

            System.out.println("Seleccione un archivo de texto...");

            int resultado = selector.showOpenDialog(null);

            // Si el usuario cancela, terminar
            if (resultado != JFileChooser.APPROVE_OPTION) {
                System.out.println("Programa finalizado.");
                break;
            }

            File archivoSeleccionado = selector.getSelectedFile();
            Path ruta = archivoSeleccionado.toPath();

            // Comprobar que sea un archivo valido
            if (!Files.isRegularFile(ruta)
                    || !Files.isReadable(ruta)) {

                System.out.println(
                        "Error: el archivo no existe o no se puede leer."
                );

                System.out.println("Seleccione otro archivo.");
                continue;
            }

            // Analizar el archivo
            try {
                AnalizarTexto.analizar(ruta);

                // Si todo salio bien, terminar
                break;

            } catch (IOException e) {

                System.out.println(
                        "Error al leer el archivo: "
                        + e.getMessage()
                );

                System.out.println(
                        "Intente seleccionar otro archivo."
                );
            }
        }
    }
}
