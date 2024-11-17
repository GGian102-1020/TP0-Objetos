public abstract class Maquina {
    protected boolean Uso;
    private String nombre;
    private double costoOperacion;

    public Maquina(String nombre, double costoOperacion) {
        this.nombre = nombre;
        this.costoOperacion = costoOperacion;
    }

    public abstract boolean puedeFabricar(Producto producto);

    public abstract boolean UsarMaquina();


    public abstract boolean enUso();

}