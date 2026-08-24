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
        if(monto>this.saldo || monto<0 ){
            System.out.println("accion no disponible saldo insuficiente o no se puede ingresar num negativos");
        }else{
            this.saldo-=monto;
            System.out.println("Retiro exitoso");
        }
    }

    public void Despositar(double monto){
        if(monto<0){
            System.out.println("accion no disponible no se ingresa num negativos");
        }else{
            this.saldo+=monto;
            System.out.println("Desposito exitoso");
        }
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void consulta(){
        System.out.println("Saldo disponible: $" + getSaldo());
    }
    
}
