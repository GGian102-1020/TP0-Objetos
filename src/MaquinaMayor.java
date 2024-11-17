public class MaquinaMayor extends Maquina {

    public MaquinaMayor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }


    public boolean puedeFabricar(Producto producto) {
        return true;
    }
    @Override
    public boolean UsarMaquina(Producto producto) {
        return this.Uso= true;
    }

    @Override
    public boolean enUso() {
        return this.Uso;
    }
}

