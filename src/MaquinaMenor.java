import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MaquinaMenor extends Maquina {
    protected ArrayList<String> ColaProcesos;
    private Set<String> materialesAceptados;
    private Set<String> productosNoAceptados;


    
    public MaquinaMenor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
        this.materialesAceptados = new HashSet<>();
        materialesAceptados.add("Plastico");;
        materialesAceptados.add("Madera");

    }

    public boolean puedeFabricar(Producto producto) {
        return producto.getAncho() <= 120 && producto.getAlto() <= 120 && materialesAceptados.contains(producto.getMaterial());
    }

    @Override
    public boolean fabricar(Producto producto) {
        if (this.uso && puedeFabricar(producto)) {
            ColaProcesos.add(producto.getNombre());
            producto.estado = producto.estados.get(1);
        }
        producto.estado = producto.estados.get(2);
        return this.uso = true;
    }

    @Override
    public boolean enUso() {
        return this.uso;
    }
}
