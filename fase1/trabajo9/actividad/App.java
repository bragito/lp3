package fase1.trabajo9.actividad;

// PRUEBA DE Panel para administrar esquema complejo 
// Prueba de MarcoPanel 
import javax.swing.JFrame; 

public class App 
{ 
    public static void main(String[] args) { 
        MarcoPanel marcoPanel = new MarcoPanel(); 
        marcoPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        marcoPanel.setSize(450, 200); 
        marcoPanel.setLocationRelativeTo(null); // Centra la ventana en pantalla
        marcoPanel.setVisible(true); 
    } 
} // fin de la clase App