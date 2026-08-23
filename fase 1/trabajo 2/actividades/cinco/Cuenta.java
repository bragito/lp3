package actividades.cinco;

public class Cuenta {
    private int id;
    private double saldo;
    private String nombre;
    private String apellidos;

    Cuenta(int id,double saldo,String nombre, String apellidos){
        this.id=id;
        this.saldo=saldo;
        this.nombre=nombre;
        this.apellidos=apellidos;
    }

    public void Retirar(double monto){
        if(monto>this.saldo){
            
        }
    }
    
}
