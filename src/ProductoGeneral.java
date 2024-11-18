public class ProductoGeneral extends Producto implements CalcularPrecio {

    private double precioPorKilo = 1000.5;
    private double precioPorTam = 555.5;
    private double peso;
    private double precio = 0;
    private int i;
    private double tam = getAncho() * getAlto();

    public ProductoGeneral(String nombre, double alto, double ancho, String material, double peso) {
        super(nombre, alto, ancho, material);
        this.peso = peso;
        int i = 0;
        this.estado = (estados.get(i));
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }

    public void usarMaquina(Maquina maquina) {
        if (maquina.puedeFabricar(this) && !maquina.enUso()) {
            this.estado = (estados.get(i + 1));
        }
    }

    @Override
    public double calcularPrecioPorPeso(double peso) {
        try {
            if (peso <= 0) {
                throw new IllegalArgumentException("El peso debe ser mayor a 0");
            }
            return peso * precioPorKilo;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public double calcularPrecioPorTam(double tam) {
        try {
            if (tam <= 0) {
                throw new IllegalArgumentException("El tamaño debe ser mayor a 0");
            }
            return tam * precioPorTam;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
    @Override
    public void setNroCliente(int reCliente) {
        this.nroCliente = reCliente;
    }

    public double getTam() {
        return peso;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return this.estado;
    }
}