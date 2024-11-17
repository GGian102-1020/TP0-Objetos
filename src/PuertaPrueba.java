public class PuertaPrueba extends Producto {

    public PuertaPrueba(String nombre, double alto, double ancho, String material) {
        super(nombre, alto, ancho, material);
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return false;
    }
}
