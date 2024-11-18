public class ProductoGeneral extends Producto implements Pesable {

    private double precioPorKilo;
    private double peso;
    private double precio;
    private int n;

    public ProductoGeneral(String nombre, double alto, double ancho, String material, double peso, double precioPorKilo) {
        super(nombre, alto, ancho, material);
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
        this.precio = 0;
        int n = 0;
        this.estado = (estados.get(n));
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }

    public void usarMaquina(Maquina maquina) {
        if (maquina.puedeFabricar(this) && !maquina.enUso()) {
            this.estado = (estados.get(n + 1));
        }
    }

    @Override
    public double calcularPrecioPorPeso(double peso) {
        try {
            if (peso <= 0) {
                throw new IllegalArgumentException("El peso debe ser mayor a 0");
            }
            return  peso * precioPorKilo;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public double getPrecio() {
        return precio;
    }
}