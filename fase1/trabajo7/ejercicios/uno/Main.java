package fase1.trabajo7.ejercicios.uno;

import java.io.*;
import java.util.*;

// ==========================================
// CLASE PERSONAJE
// ==========================================
class Personaje {
    String nombre;
    int vida, ataque, defensa, alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0)
            throw new IllegalArgumentException("Las propiedades de la tabla deben ser mayores a 0.");
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance;
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
    }

    public void añadir(Personaje p) {
        if (personajes.stream().anyMatch(x -> x.nombre.equalsIgnoreCase(p.nombre))) {
            System.out.println("-> El personaje " + p.nombre + " ya existe.");
            return;
        }
        personajes.add(p);
        guardar();
        System.out.println("-> Añadido: " + p.nombre);
    }

    public void mostrar() {
        System.out.println("--- LISTA DE PERSONAJES ---");
        personajes.forEach(p -> System.out.println(p.nombre + " [Vida: " + p.vida + ", Ataque: " + p.ataque + ", Defensa: " + p.defensa + ", Alcance: " + p.alcance + "]"));
        System.out.println("---------------------------");
    }

    public void modificar(String nombre, int v, int a, int d, int al) {
        for (Personaje p : personajes) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                p.vida = v; p.ataque = a; p.defensa = d; p.alcance = al;
                guardar();
                System.out.println("-> Modificado: " + nombre);
                return;
            }
        }
        System.out.println("-> No se encontró a " + nombre);
    }

    public void borrar(String nombre) {
        if (personajes.removeIf(p -> p.nombre.equalsIgnoreCase(nombre))) {
            guardar();
            System.out.println("-> Borrado: " + nombre);
        } else {
            System.out.println("-> No se encontró a " + nombre);
        }
    }

    private void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            personajes.forEach(pw::println);
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
                if (d.length == 5) {
                    personajes.add(new Personaje(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[2]), Integer.parseInt(d[3]), Integer.parseInt(d[4])));
                }
            }
        } catch (Exception e) {
            // Ignora líneas con formato incorrecto
        }
    }
}

// ==========================================
// CLASE PRINCIPAL (PRUEBAS CON LA TABLA)
// ==========================================
public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        System.out.println("=== AÑADIENDO DATOS SEGÚN LA TABLA ===");
        // Valores de la tabla: Caballero, Guerrero, Arquero[cite: 3]
        gestor.añadir(new Personaje("Caballero", 4, 2, 4, 2));
        gestor.añadir(new Personaje("Guerrero", 2, 4, 2, 4));
        gestor.añadir(new Personaje("Arquero", 2, 4, 1, 8));

        gestor.mostrar();

        System.out.println("\n=== MODIFICANDO (Ej: Caballero) ===");
        gestor.modificar("Caballero", 5, 3, 5, 3);
        gestor.mostrar();

        System.out.println("\n=== BORRANDO (Ej: Arquero) ===");
        gestor.borrar("Arquero");
        gestor.mostrar();
    }
}