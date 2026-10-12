package fase1.trabajo7.ejercicios.cuatro;

import java.io.BufferedReader; // Leer el archivo línea por línea.
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; // Abrir el archivo.
import java.nio.file.Path;
import java.util.HashMap; // Contar las apariciones de cada palabra.
import java.util.Map; // Almacenar palabras y frecuencias.

public class AnalizarTexto {

    public static void analizar(Path archivo) throws IOException {

        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;

        Map<String, Integer> frecuencias = new HashMap<>();

        try (BufferedReader lector = Files.newBufferedReader(
                archivo, StandardCharsets.UTF_8)) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                lineas++; // Contador de líneas.
                caracteres += linea.length(); // Sin contar saltos de línea.

                StringBuilder palabra = new StringBuilder();

                for (int i = 0; i < linea.length(); i++) {

                    char c = linea.charAt(i);

                    if (Character.isLetterOrDigit(c)) {
                        palabra.append(Character.toLowerCase(c));
                    } else {
                        if (palabra.length() > 0) {
                            contarPalabra(palabra, frecuencias);
                            palabras++;
                            palabra.setLength(0);
                        }
                    }
                }

                // Contar la última palabra de la línea.
                if (palabra.length() > 0) {
                    contarPalabra(palabra, frecuencias);
                    palabras++;
                }
            }
        }

        // Calcular el promedio de palabras por línea.
        double promedio = lineas == 0
                ? 0.0
                : (double) palabras / lineas;

        // Mostrar los resultados.
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Archivo: " + archivo.getFileName());
        System.out.println("Total de lineas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de caracteres: " + caracteres);

        System.out.printf(
                "Promedio de palabras por linea: %.2f%n",
                promedio
        );

        mostrarMasFrecuentes(frecuencias);
    }

    // Registrar una palabra y actualizar su frecuencia.
    private static void contarPalabra(
            StringBuilder palabra,
            Map<String, Integer> frecuencias) {

        if (palabra.length() > 0) {

            String texto = palabra.toString();

            frecuencias.put(
                    texto,
                    frecuencias.getOrDefault(texto, 0) + 1
            );
        }
    }

    // Mostrar la palabra o las palabras con mayor frecuencia.
    private static void mostrarMasFrecuentes(
            Map<String, Integer> frecuencias) {

        System.out.println("\nPalabras mas frecuentes:");

        if (frecuencias.isEmpty()) {
            System.out.println("No hay palabras en el archivo.");
            return;
        }

        int maximo = 0;

        // Buscar la frecuencia máxima.
        for (int cantidad : frecuencias.values()) {
            if (cantidad > maximo) {
                maximo = cantidad;
            }
        }

        // Mostrar todas las palabras que tengan esa frecuencia.
        for (Map.Entry<String, Integer> entrada
                : frecuencias.entrySet()) {

            if (entrada.getValue() == maximo) {
                System.out.println(
                        entrada.getKey() + ": " + entrada.getValue()
                );
            }
        }
    }
}
