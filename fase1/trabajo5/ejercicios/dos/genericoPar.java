package fase1.trabajo5.ejercicios.dos;
public class genericoPar<F,S>{
    private F primero;
    private S segundo;

    public  genericoPar(F primero,S segundo){
        this.primero=primero;
        this.segundo=segundo;
    }

    public F getPrimero(){return primero;}
    public S getSegundo(){return segundo;}

    public void setPrimero(F elemento){this.primero=elemento;}
    public void setSegundo(S elemento){this.segundo=elemento;}

    @Override 
    public String toString(){
        return "(Primero: "+primero+" Segundo: "+segundo+" )";
    }

    public boolean esIgual(genericoPar<F,S> otro){
        return primero.equals(otro.getPrimero()) && 
        segundo.equals(otro.getSegundo());
    }
}