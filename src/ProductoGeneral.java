public class ProductoGeneral extends Producto {

    public ProductoGeneral(String nombre, double alto, double ancho, String material) {
        super(nombre, alto, ancho, material);
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }
}