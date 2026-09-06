public abstract class Persona implements ConfigConstantes {
    private String id;
    private String nombre;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    public abstract String obtenerRol();

    public void mostrarInformacion() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Rol: " + obtenerRol());
    }
}