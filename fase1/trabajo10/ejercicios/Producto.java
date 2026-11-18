package fase1.trabajo10.ejercicios;

public class Producto {

    private String nombre, categoria;
    private double precio;
    private int cantidadStock;

    public Producto(String n, double p, int c, String cat) {
        setNombre(n);
        setPrecio(p);
        setCantidadStock(c);
        setCategoria(cat);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String v) {
        nombre = v;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double v) {
        if (v < 0)
            throw new IllegalArgumentException("Precio negativo");
        precio = v;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int v) {
        if (v < 0)
            throw new IllegalArgumentException("Stock negativo");
        cantidadStock = v;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String v) {
        categoria = v;
    }

    public String toString() {
        return String.format(
            "Producto: %s | Precio: S/ %.2f | Stock: %d | Categoría: %s",
            nombre, precio, cantidadStock, categoria
        );
    }
}