package fase1.trabajo4.ejercicios.dos;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora=new Calculadora();
        try{
            double suma=calculadora.sumar(9,10);
            double resta=calculadora.restar(100,9.81);
            double multiplicacion=calculadora.multiplicar(5,10);
            double division=calculadora.dividir(10,0);

            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);
            System.out.println("División: " + division);
        }catch (DivisionPorCeroExcepcion e){
            System.out.println("Error: "+e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Argumente Invalido: "+e.getMessage());
        }catch(ArithmeticException e){
            System.out.println("Error Aritmetico: "+e.getMessage());
        }
    }
}
