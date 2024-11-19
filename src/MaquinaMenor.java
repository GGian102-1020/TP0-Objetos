import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaquinaMenor extends Maquina {
    protected ArrayList<String> ColaProcesos = new ArrayList<>();
    private Set<String> materialesAceptados;



    
    public MaquinaMenor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
        this.materialesAceptados = new HashSet<>();
        materialesAceptados.add("Plastico");;
        materialesAceptados.add("Madera");

    }

    public boolean puedeFabricar(Producto producto) {
        return producto.getAncho() <= 120 && producto.getAlto() <= 120 && materialesAceptados.contains(producto.getMaterial());
    }


    public void fabricar(Producto producto) {
        if (this.uso && puedeFabricar(producto)) {
            this.ColaProcesos.add(producto.getNombre());
            producto.estado = "En espera";
        }
        producto.estado = "Terminado";
        this.uso = true;
    }

    @Override
    public boolean enUso() {
        return this.uso;
    }




    public ArrayList<String> getColaProcesos() {
        return ColaProcesos;
    }



    public String getNombre() {
        return nombre;
    }

}
