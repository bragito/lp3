package actividades.uno;
public class EjemploCoche {
    public static void main(String[] args) {
        Coche cocheDeportivo = new Coche(
                "Ferrari", "F8", 2022, 300000
        );

        Coche cocheTodoTerreno = new Coche(
                "Toyota", "Hilux", 2008, 80000
        );

        // COCHE DEPORTIVO

        System.out.println("=== COCHE DEPORTIVO ===");

        cocheDeportivo.encender();

        cocheDeportivo.acelerar(50);
        cocheDeportivo.acelerar(50);

        cocheDeportivo.frenar(30);

        if (cocheDeportivo.aplicarDescuento()) {
            System.out.println("Se aplicó el descuento");
        } else {
            System.out.println("No se aplicó el descuento");
        }

        System.out.println("Precio: " + cocheDeportivo.getprecio());

        cocheDeportivo.apagar();

        // COCHE TODO TERRENO

        System.out.println("\n=== COCHE TODO TERRENO ===");

        cocheTodoTerreno.encender();

        cocheTodoTerreno.acelerar(40);
        cocheTodoTerreno.acelerar(20);

        cocheTodoTerreno.frenar(30);
        System.out.println("Precio: " + cocheTodoTerreno.getprecio());        // Aplicar descuento
        if (cocheTodoTerreno.aplicarDescuento()) {
            System.out.println("Se aplicó el descuento");
        } else {
            System.out.println("No se aplicó el descuento");
        }

        System.out.println("Precio final: "
                + cocheTodoTerreno.getprecio());

        cocheTodoTerreno.apagar();
    }
}
