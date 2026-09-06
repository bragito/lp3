package actividades.cuatro;

public class Persona {
    private int id;
    private String nombre;
    private String apellidos;
    private Cuenta cuenta;

    public Persona(int id, String nombre, String apellidos, int numero) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cuenta = new Cuenta(numero);
    }

    // Getter y Setter de id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter de nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter de apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getter y Setter de cuenta
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cuenta=" + cuenta +
                '}';
    }
    public static void main(String[] args) {

        // Crear una persona
        Persona persona1 = new Persona(1, "Juan", "Pérez", 1001);
        
        // Mostrar los datos
        System.out.println(persona1);
        // Modificar algunos datos
        persona1.setNombre("Carlos");
        persona1.setApellidos("Gómez");
        persona1.getCuenta().setSaldo(1500);
        // Mostrar nuevamente
        System.out.println(persona1);

        // Acceder a la cuenta
        System.out.println("Número de cuenta: " + persona1.getCuenta());
    }
}
