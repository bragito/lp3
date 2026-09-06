package fase1.trabajo3.ejercicios.cuatro;

public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    private String modelo;

    public ImpresoraMultifuncional(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("[" + modelo + "] (Multifuncional) Imprimiendo documento: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("[" + modelo + "] Escaneando el documento físico: " + documento);
    }
} 
