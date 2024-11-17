public class MaquinaMayor extends Maquina {

    public MaquinaMayor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }


    public boolean puedeFabricar(Producto producto) {
        return true;
    }
}
