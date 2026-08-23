package actividades.dos;

public class ContadorTest {

    public static void main(String[] args) {

        System.out.println("Contadores creados: "
                + Contador.getNContadores());

        System.out.println("Último contador creado: "
                + Contador.getUltimoContador());

        // Crear contador con valor inicial 3
        Contador c1 = new Contador(3);

        System.out.println("\nDespués de crear c1:");
        System.out.println("Valor de c1: " + c1.getValor());
        System.out.println("Contadores creados: "
                + Contador.getNContadores());
        System.out.println("Último contador creado: "
                + Contador.getUltimoContador());

        // Crear contador usando el constructor por defecto
        Contador c2 = new Contador();

        System.out.println("\nDespués de crear c2:");
        System.out.println("Valor de c2: " + c2.getValor());
        System.out.println("Contadores creados: "
                + Contador.getNContadores());
        System.out.println("Último contador creado: "
                + Contador.getUltimoContador());

        // Crear otro contador con valor 20
        Contador c3 = new Contador(20);

        System.out.println("\nDespués de crear c3:");
        System.out.println("Valor de c3: " + c3.getValor());
        System.out.println("Contadores creados: "
                + Contador.getNContadores());
        System.out.println("Último contador creado: "
                + Contador.getUltimoContador());
    }
}
