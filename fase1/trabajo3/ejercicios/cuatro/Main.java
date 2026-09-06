package fase1.trabajo3.ejercicios.cuatro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear dispositivos
        Impresora impresoraSencilla = new Impresora("HP DeskJet 2300");
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional("Epson EcoTank L5290");

        ServicioDeImpresion servicio = new ServicioDeImpresion();

        // 1. Lote de impresión: Acepta cualquier dispositivo 'Imprimible'
        List<Imprimible> dispositivosImpresion = List.of(impresoraSencilla, multifuncional);
        servicio.procesarImpresiones(dispositivosImpresion, "Reporte_Financiero.pdf");

        // 2. Lote de escaneo: Solo acepta dispositivos 'Escaneable'
        // impresoraSencilla NO entra en esta lista, evitando errores en tiempo de ejecución.
        List<Escaneable> dispositivosEscaneo = List.of(multifuncional);
        servicio.procesarEscaneos(dispositivosEscaneo, "Contrato_Firmado.pdf");
    }
} 