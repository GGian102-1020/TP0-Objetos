public class Accesorio extends Producto implements Pesable {
    private double peso;

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
            double tarifaPorPeso = 10.0;
            return peso * tarifaPorPeso;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }
}