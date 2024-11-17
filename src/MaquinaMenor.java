public class MaquinaMenor extends Maquina {

    public MaquinaMenor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }

    public boolean puedeFabricar(Producto producto) {
            return true ;
    }
}
