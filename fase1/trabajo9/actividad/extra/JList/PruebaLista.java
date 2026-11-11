package fase1.trabajo9.actividad.extra.JList;

// Fig. 12.24: PruebaLista.java
// Prueba de MarcoLista.
import javax.swing.JFrame;

public class PruebaLista
{
    public static void main(String[] args)
    {
        MarcoLista marcoLista = new MarcoLista();
        marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoLista.setSize(350, 150);
        marcoLista.setVisible(true);
    }
} // fin de la clase PruebaLista