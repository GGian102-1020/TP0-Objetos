public class Maquina {
    private String tipo;
    private boolean enUso;
    private Producto productoEnFabricacion;
    private int tiempoEnUso;

    public Maquina (String tipo) {
        this.tipo = tipo;
        this.enUso = false;
        this.productoEnFabricacion = null;
        this.tiempoEnUso = 0;
    }

    public void fabricarProducto(Producto producto) {
        if (!enUso) {
            System.out.println("Primero hay que activar la maquina para fabricar.");
        } else {
            this.productoEnFabricacion = producto;
            this.enUso = true;
            System.out.println("Fabricando producto de material " + producto.getMaterial() + " con precio de " + producto.getPrecio());
        }
    }

    public void usarMaquina() {
        this.enUso = true;
    }

    public void finalizarFabricacion() {
        this.productoEnFabricacion = null;
        this.enUso = false;
        this.tiempoEnUso = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean estaEnUso() {
        return enUso;
    }

    public Producto getProductoEnFabricacion() {
        return productoEnFabricacion;
    }

    public int getTiempoEnUso() {
        return tiempoEnUso;
    }

}
