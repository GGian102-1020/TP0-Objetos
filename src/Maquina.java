public abstract class Maquina {
    protected String nombre;
    protected double costoOperacion;

    public Maquina(String nombre, double costoOperacion) {
        this.nombre = nombre;
        this.costoOperacion = costoOperacion;
    }

    public abstract boolean puedeFabricar(Producto producto);
}