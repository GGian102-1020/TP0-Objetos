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
    public void fabricar(Producto producto) {
        if(this.uso){
            ColaProcesos.add(producto.getNombre());
            producto.estado=producto.estados.get(1);
        }
        producto.estado=producto.estados.get(2);
         this.uso= true;
    }

    @Override
    public boolean enUso() {
        return this.uso;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getColaProcesos() {
        return ColaProcesos;
    }
}

