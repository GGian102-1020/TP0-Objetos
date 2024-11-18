public class Accesorio extends Producto implements CalcularPrecio {
    private double peso;
    private double precio = 0;
    private double precioPorKilo = 675.25;
    private double precioPorTam = 325.25;
    private double tam = getAncho() * getAlto();

    public Accesorio(String nombre, double alto, double ancho, String material, double peso) {
        super(nombre, alto, ancho, material);
        this.peso = peso;
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
            this.precio = peso * precioPorKilo;
            return this.precio;
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
            this.precio = tam * precioPorTam;
            return this.precio;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }


    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }
}