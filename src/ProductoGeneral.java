public class ProductoGeneral extends Producto implements Pesable {

    private double precioPorKilo;

    public ProductoGeneral(String nombre, double alto, double ancho, String material, double precioPorKilo) {
        super(nombre, alto, ancho, material);
        this.precioPorKilo = precioPorKilo;
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
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
}

