public abstract class Maquina {
    private String nombre;
    private double costoOperacion;

    public Maquina(String nombre, double costoOperacion) {
        this.nombre = nombre;
        this.costoOperacion = costoOperacion;
    }

    public abstract boolean puedeFabricar(Producto producto);
}