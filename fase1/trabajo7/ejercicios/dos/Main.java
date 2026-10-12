package fase1.trabajo7.ejercicios.dos;
import java.io.*;
import java.util.*;

// ==========================================
// CLASE PERSONAJE
// ==========================================
class Personaje {
    String nombre;
    int nivel, vida, ataque, defensa, alcance;

    public Personaje(String nombre, int nivel, int vida, int ataque, int defensa, int alcance) {
        if (nivel <= 0 || vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0)
            throw new IllegalArgumentException("Las propiedades deben ser mayores a 0.");
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    // Aumentar nivel y escalar atributos automáticamente
    public void subirNivel() {
        nivel++;
        vida += 2;
        ataque += 2;
        defensa += 1;
        alcance += 1;
    }

    @Override
    public String toString() {
        return String.format("%s [Nivel: %d | Vida: %d | Ataque: %d | Defensa: %d | Alcance: %d]",
                nombre, nivel, vida, ataque, defensa, alcance);
    }

    public String aLineaTexto() {
        return nombre + "," + nivel + "," + vida + "," + ataque + "," + defensa + "," + alcance;
    }
}

// ==========================================
// CLASE GESTOR
// ==========================================
class Gestor {
    private List<Personaje> personajes = new ArrayList<>();
    private final String archivo = "personajes.txt";

    public Gestor() {
        cargar();
        // Si está vacío al iniciar, carga los personajes base de la tabla
        if (personajes.isEmpty()) {
            añadir(new Personaje("Caballero", 1, 4, 2, 4, 2));
            añadir(new Personaje("Guerrero", 1, 2, 4, 2, 4));
            añadir(new Personaje("Arquero", 1, 2, 4, 1, 8));
        }
    }

    public void añadir(Personaje p) {
        if (personajes.stream().anyMatch(x -> x.nombre.equalsIgnoreCase(p.nombre))) {
            return; // No se crea si ya existe
        }
        personajes.add(p);
        guardar();
    }

    public void mostrar() {
        System.out.println("--- LISTA DE PERSONAJES ---");
        personajes.forEach(System.out::println);
        System.out.println("---------------------------");
    }

    // 1. Filtrar / Ordenar Personajes por Atributo (ej: por Ataque descendiente)
    public void mostrarOrdenadosPor(String atributo) {
        System.out.println("--- ORDENADOS POR " + atributo.toUpperCase() + " ---");
        Comparator<Personaje> comparador = switch (atributo.toLowerCase()) {
            case "vida" -> Comparator.comparingInt(p -> p.vida);
            case "ataque" -> Comparator.comparingInt(p -> p.ataque);
            case "defensa" -> Comparator.comparingInt(p -> p.defensa);
            case "alcance" -> Comparator.comparingInt(p -> p.alcance);
            default -> Comparator.comparingInt(p -> p.nivel);
        };
        personajes.stream().sorted(comparador.reversed()).forEach(System.out::println);
        System.out.println("----------------------------------------");
    }

    // 3. Actualizar Atributo Individual
    public void actualizarAtributoUnico(String nombre, String atributo, int nuevoValor) {
        for (Personaje p : personajes) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida" -> p.vida = nuevoValor;
                    case "ataque" -> p.ataque = nuevoValor;
                    case "defensa" -> p.defensa = nuevoValor;
                    case "alcance" -> p.alcance = nuevoValor;
                    default -> { System.out.println("Atributo no válido."); return; }
                }
                guardar();
                System.out.println("-> " + nombre + " actualizado (" + atributo + " = " + nuevoValor + ")");
                return;
            }
        }
        System.out.println("-> Personaje no encontrado.");
    }

    // 4. Mostrar Estadísticas Generales
    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay estadísticas disponibles.");
            return;
        }
        double promVida = personajes.stream().mapToInt(p -> p.vida).average().orElse(0);
        double promAtaque = personajes.stream().mapToInt(p -> p.ataque).average().orElse(0);
        double promDefensa = personajes.stream().mapToInt(p -> p.defensa).average().orElse(0);
        double promAlcance = personajes.stream().mapToInt(p -> p.alcance).average().orElse(0);

        System.out.println("=== ESTADÍSTICAS GENERALES ===");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Promedios -> Vida: %.1f | Ataque: %.1f | Defensa: %.1f | Alcance: %.1f%n",
                promVida, promAtaque, promDefensa, promAlcance);
        System.out.println("==============================");
    }

    // 5. Importar Personajes desde un Archivo Externo
    public void importarDesdeArchivo(String rutaExterna) {
        File f = new File(rutaExterna);
        if (!f.exists()) {
            System.out.println("El archivo externo no existe.");
            return;
        }
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                if (d.length == 6) {
                    Personaje p = new Personaje(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[2]), 
                                                Integer.parseInt(d[3]), Integer.parseInt(d[4]), Integer.parseInt(d[5]));
                    añadir(p);
                }
            }
            System.out.println("-> Importación completada desde: " + rutaExterna);
        } catch (Exception e) {
            System.out.println("Error al importar el archivo.");
        }
    }

    // 6. Subir de Nivel a un personaje
    public void subirNivelPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                p.subirNivel();
                guardar();
                System.out.println("-> " + nombre + " subió al nivel " + p.nivel + "!");
                return;
            }
        }
    }

    public void borrar(String nombre) {
        if (personajes.removeIf(p -> p.nombre.equalsIgnoreCase(nombre))) {
            guardar();
            System.out.println("-> Borrado: " + nombre);
        }
    }

    private void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            personajes.forEach(p -> pw.println(p.aLineaTexto()));
        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    private void cargar() {
        File f = new File(archivo);
        if (!f.exists()) return;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                if (d.length == 6) {
                    personajes.add(new Personaje(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[2]), 
                                                 Integer.parseInt(d[3]), Integer.parseInt(d[4]), Integer.parseInt(d[5])));
                }
            }
        } catch (Exception e) {
            // Ignora líneas corruptas
        }
    }
}

// ==========================================
// CLASE PRINCIPAL (PRUEBAS DE NUEVAS FUNCIONES)
// ==========================================
public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        System.out.println("=== 1. ESTADO INICIAL (Con carga predefinida) ===");
        gestor.mostrar();

        System.out.println("\n=== 2. SUBIR DE NIVEL (Mejora de atributos) ===");
        gestor.subirNivelPersonaje("Caballero");
        gestor.mostrar();

        System.out.println("\n=== 3. ORDENAR POR ATAQUE ===");
        gestor.mostrarOrdenadosPor("ataque");

        System.out.println("\n=== 4. ACTUALIZAR UN SOLO ATRIBUTO (Vida del Arquero a 10) ===");
        gestor.actualizarAtributoUnico("Arquero", "vida", 10);
        gestor.mostrar();

        System.out.println("\n=== 5. ESTADÍSTICAS GENERALES ===");
        gestor.mostrarEstadisticas();
    }
}