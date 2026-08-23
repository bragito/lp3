package actividades.uno;
public class Coche{
    private String marca;
    private String modelo;
    private int aniofabriacion;
    private double precio;
    private boolean encendido;
    private double velocidad;
    public static final double DESCUENTO=10;

    // Constructor default
    public Coche() {
        this.marca = "";
        this.modelo="";
        this.aniofabriacion = 0;
        this.precio = 0.0;
        this.encendido = false;
        this.velocidad = 0.0;
    }

    // Constructor de 4 parámetros
    public Coche(String marca, String modelo, int anio, double precio ) {
        this.marca = marca;
        this.modelo = modelo;
        this.aniofabriacion = anio;
        this.precio = precio;
        this.encendido = false;
        this.velocidad = 0.0;
    }

    public void encender(){
        this.encendido=true;
        System.out.println("el coche "+this.modelo+" esta encendido");
    }
    public void apagar(){
        
        this.encendido=false;
        System.out.println("el coche "+this.modelo+" esta apagado");
    }

    public void acelerar(double velo){
        if (this.encendido) {
        this.velocidad += velo;
        System.out.println("El coche " + this.modelo +
                " está acelerando a " + this.velocidad + " KM/h");
        } else {
            System.out.println("El coche está apagado");
        }
    }

    public void frenar(double velo){
        this.velocidad-=velo;
        if(this.velocidad<0){this.velocidad=0;}
        System.out.println("el coche "+this.modelo+" esta frenando");
    }
    //metodos get y sets

    public String getmarca(){
        return marca;
    }
    public void setmarca(String marca){
        this.marca=marca;
    }

    public String getmodelo(){
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo=modelo;
    }
    //año
    public int getaniofabriacion(){
        return aniofabriacion;
    }
    public void setaniofabriacion(int aniofabriacion){
        this.aniofabriacion=aniofabriacion;
    }
    //precio
    public double getprecio(){
        return precio;
    }
    public void setprecio(double precio){
        this.precio=precio;
    }
    //encendido
    public boolean isEncendido() {
    return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    //velocidad
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }


    public boolean aplicarDescuento(){
        if (this.aniofabriacion<2010){
            this.precio=this.precio-(this.precio*DESCUENTO/100);
            return true;
        }
        return false;
    }

}
