public abstract class Producto {
    private String nombre;
    private double alto;
    private double ancho;
    private String material;

    public Producto(String nombre, double alto, double ancho, String material) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
    public double getAlto(){
        return alto;
    }

    public double getAncho(){
        return ancho;
    }

    public abstract boolean verificarProduccion(Maquina maquina);


}
