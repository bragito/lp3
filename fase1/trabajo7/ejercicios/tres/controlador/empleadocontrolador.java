package fase1.trabajo7.ejercicios.tres.controlador;

import fase1.trabajo7.ejercicios.tres.modelo.Empleado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class empleadocontrolador {

    private final String Archivo = "empleados.txt";
    private List<Empleado> empleados = new ArrayList<>();

    public List<Empleado> leerEmpleados() {
        empleados = new ArrayList<>();
        File fichero = new File(Archivo);

        if (!fichero.exists()) {
            return empleados;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);

                // Comprueba que existan exactamente 3 campos
                if (datos.length != 3) {
                    System.out.println("Registro inválido: " + linea);
                    continue;
                }

                try {
                    int numero = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    double saldo = Double.parseDouble(datos[2]);

                    Empleado empleado = new Empleado(numero, nombre, saldo);
                    empleados.add(empleado);

                } catch (NumberFormatException e) {
                    System.out.println(
                        "Error en los datos: " + linea
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                "Error al leer el archivo: " + e.getMessage()
            );
        }

        return empleados;
    }
    public void guardarEmpleados(List<Empleado> lista)throws IOException{
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(Archivo))){
            for (Empleado e: lista){
                bw.write(
                    e.getnumero()+";"
                    +e.getnombre()+";"
                    +e.getsaldo()
                );
                bw.newLine();
            }
        }
    }
    public boolean agregarEmpleado(Empleado nuevo)throws IOException{
        //lee empleados que ya existen
        List<Empleado> lista= leerEmpleados();
        //Comprueba si el num esta registrado
        for(Empleado e: lista){
            if(e.getnumero()==nuevo.getnumero()){
                return false;
            }
        }
        //agregamos al nuevo empleado a la lista
        lista.add(nuevo);
        guardarEmpleados(lista);
        return true;
    }

    public Empleado buscarEmpleado(int numero) throws IOException{
        List<Empleado> lista=leerEmpleados();
        for(Empleado e: lista){
            if(e.getnumero()==numero){
                return e;
            }
        }
        return  null;
    }

    public boolean eliminarEmpleado(int numero)throws IOException{
        List<Empleado> lista=leerEmpleados();
        boolean eliminar=lista.removeIf(e->e.getnumero()==numero);
        if(eliminar){
            guardarEmpleados(lista);
        }
        return eliminar;
    }
}