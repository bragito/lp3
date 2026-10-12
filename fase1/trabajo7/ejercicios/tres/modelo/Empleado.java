package fase1.trabajo7.ejercicios.tres.modelo;

public class Empleado {
    private int numero;
    private String nombre;
    private double saldo;

    public Empleado(int NUM,String N,double S){
        this.numero=NUM;
        this.nombre=N;
        this.saldo=S;
    }
    //metodos gets
    public int getnumero(){return numero;}
    public String getnombre(){return nombre;}
    public double getsaldo(){return saldo;}
    //metodos sets
    public void setnumero(int num){this.numero=num;}
    public void setnombre(String nom){this.nombre=nom;}
    public void setnumero(double s){this.saldo=s;}
    //mostramos datos del empleado
    public String toString(){
        return  "numero: "+numero
        +"| Nombre "+nombre
        +"| Saldo "+saldo;
    }
}
