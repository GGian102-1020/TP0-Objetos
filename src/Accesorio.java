import java.util.HashMap;
import java.util.Map;

public class Accesorio extends Producto implements CalcularPrecio {
    private double peso;
    private double precio = 0;
    private double precioPorKilo = 675.25;
    private double precioPorTam = 325.25;
    private double tam = getAncho() * getAlto();
    private static Map<Integer, Double> clientePrecioMap = new HashMap<>();

    public Accesorio(String nombre, double alto, double ancho, String material, double peso) {
        super(nombre, alto, ancho, material);
        this.peso = peso;
        this.precio = calcularPrecio();
    }

    public double getPeso() {
        return peso;
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

    private double calcularPrecio() {
        return calcularPrecioPorPeso(this.peso) + calcularPrecioPorTam(this.tam);
    }

    @Override
    public void setNroCliente(int nroCliente) {
        super.setNroCliente(nroCliente);
        agregarClientePrecio(nroCliente);
    }

    private void agregarClientePrecio(int nroCliente) {
        clientePrecioMap.put(nroCliente, this.precio);
    }

    public static Map<Integer, Double> getClientePrecioMap() {
        return clientePrecioMap;
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }

    public double getTam() {
        return tam;
    }

    public double getPrecio() {
        return precio;
    }
}
