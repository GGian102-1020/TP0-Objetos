public class MaquinaMayor extends Maquina {

    public MaquinaMayor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }


    public boolean puedeFabricar(Producto producto) {
        return true;
    }

    @Override
    public boolean Fabricar(Producto producto) {
        if(this.uso){
            return false;
        }
        return this.uso= true;
    }

    @Override
    public boolean enUso() {
        return this.uso;
    }
}

