package fase1.trabajo3.ejercicios.dos.formas;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Forma> formas = List.of(
            new Circulo(),
            new Rectangulo(),
            new Triangulo()
        );

        for (Forma forma : formas) {
            forma.dibujar();
        }
    }
}
