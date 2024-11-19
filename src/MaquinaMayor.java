import java.util.ArrayList;

public class MaquinaMayor extends Maquina {
    protected ArrayList<String> ColaProcesosA;


    public MaquinaMayor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }


    public boolean puedeFabricar(Producto producto) {
        return true;
    }

    @Override
    public void fabricar(Producto producto) {
        if(this.uso){
            ColaProcesosA.add(producto.getNombre());
            producto.estado="En espera";
        }
        producto.estado="Terminado";
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
        return ColaProcesosA;
    }
}

