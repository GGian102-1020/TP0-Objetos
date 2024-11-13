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
        double tarifaPorPeso = 10.0; // ejemplo
        return peso * tarifaPorPeso;
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }
}