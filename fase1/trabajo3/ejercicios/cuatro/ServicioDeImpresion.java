package fase1.trabajo3.ejercicios.cuatro;

import java.util.List;

public class ServicioDeImpresion {

    public void procesarImpresiones(List<Imprimible> impresoras, String documento) {
        System.out.println("--- INICIANDO LOTE DE IMPRESIÓN ---");
        for (Imprimible impresora : impresoras) {
            impresora.imprimir(documento);
        }
    }

    public void procesarEscaneos(List<Escaneable> escáneres, String documento) {
        System.out.println("\n--- INICIANDO LOTE DE ESCANEO ---");
        for (Escaneable escaner : escáneres) {
            escaner.escanear(documento);
        }
    }
}