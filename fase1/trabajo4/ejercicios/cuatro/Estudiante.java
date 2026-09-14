package fase1.trabajo4.ejercicios.cuatro;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String carrera;

    public Estudiante(String nombre,String apellido, String carrera){
        ValidarTexto(nombre,"nombre");
        ValidarTexto(apellido,"apellido");
        ValidarTexto(carrera,"carrera");

        this.nombre=nombre;
        this.apellido=apellido;
        this.carrera=carrera;
    }


    private void ValidarTexto(String valor,String campo){
        if(valor==null || valor.trim().isEmpty()){
            throw new IllegalArgumentException(
                "el campo "+campo+" no puede ser nulo o vacio"
            );
        }
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCarrera() {
        return carrera;
    }
}
