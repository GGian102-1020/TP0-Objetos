public abstract class Producto {

    private String material;
    private double precio;

    public Producto (String material, double precio) {
        this.material = material;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMaterial() {
        return material;
    }

    public abstract void mostrarDetalles();

    public abstract void fabricar();
}
