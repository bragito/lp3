package fase1.trabajo3.ejercicios.cuatro;

public class Impresora implements Imprimible {
    private String modelo;

    public Impresora(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("[" + modelo + "] Imprimiendo el documento: " + documento);
    }
}