package fase1.trabajo4.ejercicios.tres;

public class Main {

    public static void main(String[] args) {
        Numero numero=new  Numero();

        try{
            numero.setValor(25.12);
            System.out.println("El valor es: " + numero.getValor());
            numero.setValor(-25.12);
            System.out.println("El valor es: " + numero.getValor());
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
