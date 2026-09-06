package lp3.fase1.trabajo3.ejercicios.uno;

public class Empleado {

    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(String nombre, double salario, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setSalario(double salario) {
        this.salario = salario;
    }

    protected void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + nombre +
               " | Salario por hora: " + salario +
               " | Departamento: " + departamento;
    }
}
