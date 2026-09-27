package fase1.trabajo5.ejercicios.uno;

public class Main {
    public static void main(String[] args) {
        genericoPar<String,Integer> par=new genericoPar<>("juan",35);
        System.out.println(par);
        par.setPrimero("Maria");
        par.setSegundo(30);
        System.out.println(par);
    }
}
