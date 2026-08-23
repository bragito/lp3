package actividades.dos;
public class Contador {
    private static int acumulador=0;
    final static int VALOR_INICIAL=10;
    private int valor;
    private static int nContadores = 0;
    private static int ultimoContador = 0;

    public static int acumulador(){
        return acumulador;
    }

    public static int getNContadores() {
        return nContadores;
    }

    public static int getUltimoContador() {
        return ultimoContador;
    }

    public Contador(int valor){
        this.valor=valor;
        this.acumulador+=valor;
        nContadores++;
        ultimoContador = valor;
    }

    public Contador(){
        this(Contador.VALOR_INICIAL);
    }

    public void inc(){
        this.valor++;
        Contador.acumulador++;
    }

    public int getValor(){
        return this.valor;
    }
}
