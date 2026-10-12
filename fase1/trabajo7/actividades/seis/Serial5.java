package fase1.trabajo7.actividades.seis;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// ==========================================
// 1. CLASE BASE PERSONA
// ==========================================
class Persona implements Serializable {
    protected String nif;
    protected String nombre;
    protected int edad;

    public Persona(String nif, String nombre, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {
    }
}

// ==========================================
// 2. CLASE FECHA
// ==========================================
class Fecha implements Serializable {
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha() {
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}

// ==========================================
// 3. CLASE ALUMNO
// ==========================================
class Alumno extends Persona {
    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nif, nombre, edad);
        this.fechaMatricula = new Fecha();
        setFechaMatricula(fechaMatricula);
    }

    public Alumno() {
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes(fechaMatricula.getMes());
        this.fechaMatricula.setAño(fechaMatricula.getAño());
    }
}

// ==========================================
// 4. CLASE PRINCIPAL (SERIAL5)
// ==========================================
public class Serial5 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Alumno a;
        Fecha f;

        try {
            // Nota: Se usa "alumnos.dat" en la raíz. Si prefieres la ruta original y existe la carpeta, cámbialo a "/ficheros/alumnos.dat"
            fos = new FileOutputStream("alumnos.dat");
            salida = new ObjectOutputStream(fos);
            
            f = new Fecha(5, 9, 2011);
            a = new Alumno("12345678A", "Lucas González", 20, f);
            salida.writeObject(a);
            
            f = new Fecha(7, 9, 2011);
            a = new Alumno("98765432B", "Anacleto Jiménez", 19, f);
            salida.writeObject(a);
            
            f = new Fecha(8, 9, 2011);
            a = new Alumno("78234212Z", "María Zapata", 21, f);
            salida.writeObject(a);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null) fos.close();
                if (salida != null) salida.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}