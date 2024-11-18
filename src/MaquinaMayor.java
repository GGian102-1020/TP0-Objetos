import java.util.ArrayList;

public class MaquinaMayor extends Maquina {
    protected ArrayList<String> ColaProcesos;


    public MaquinaMayor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }


    public boolean puedeFabricar(Producto producto) {
        return true;
    }

    @Override
    public boolean fabricar(Producto producto) {
        if(this.uso){
            ColaProcesos.add(producto.getNombre());
            producto.estado=producto.estados.get(1);
        }
        producto.estado=producto.estados.get(2);
        return this.uso= true;
    }

    @Override
    public boolean enUso() {
        return this.uso;
    }
}

