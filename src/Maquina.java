public abstract class Maquina {
    protected boolean uso;
    private String nombre;
    private double costoOperacion;

    public abstract void crearMaquina ();

    public abstract boolean puedeFabricar(Producto producto);

    public abstract boolean fabricar(Producto producto);

    public abstract boolean enUso();

    public void usarMaquina(){};

}
