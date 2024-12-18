public abstract class Maquina {
    protected boolean uso;
    protected String nombre;
    private double costoOperacion;

    public Maquina (String nombre, double costoOperacion){
        this.nombre = nombre;
        this.costoOperacion = costoOperacion;
    }

    public abstract boolean puedeFabricar(Producto producto);

    public abstract void fabricar(Producto producto);

    public abstract boolean enUso();

    public void usarMaquina(){};

}
