package fase1.trabajo4.ejercicios.uno;
import java.io.IOException;

public class Procesador {

    private LeerEntrada entrada;
    private char caracter;

    public Procesador() { //constructor
        entrada = new LeerEntrada(System.in);
    }

    public void procesar() throws IOException,
            ExcepcionVocal,
            ExcepcionNumero,
            ExcepcionBlanco,
            ExcepcionSalida {

        caracter = entrada.getChar();

        if (caracter == 'x' || caracter == 'X') {
            throw new ExcepcionSalida();
        }

        if (esVocal(caracter)) {
            throw new ExcepcionVocal();
        }

        if (Character.isDigit(caracter)) {
            throw new ExcepcionNumero();
        }

        if (Character.isWhitespace(caracter)) {
            throw new ExcepcionBlanco();
        }

        System.out.println("Carácter ingresado: " + caracter);
    }

    private boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U';
    }

    public static void main(String[] args) {

        Procesador p = new Procesador();

        while (true) {

            try {
                p.procesar();

            } catch (ExcepcionVocal e) {
                System.out.println("Excepción: Vocal.");

            } catch (ExcepcionNumero e) {
                System.out.println("Excepción: Número.");

            } catch (ExcepcionBlanco e) {
                System.out.println("Excepción: Blanco.");

            } catch (ExcepcionSalida e) {
                System.out.println("Excepción: Salida.");
                break;

            } catch (IOException e) {
                System.out.println("Error de entrada.");
                break;
            }
        }
    }
}