import java.util.HashSet;
import java.util.Set;

public class MaquinaMenor extends Maquina {

    private Set<String> materialesAceptados;
    private Set<String> productosNoAceptados;

    public MaquinaMenor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
        this.materialesAceptados = new HashSet<>();
        materialesAceptados.add("Plastico");;
        materialesAceptados.add("Madera");
        this.productosNoAceptados = new HashSet<>();
        productosNoAceptados.add("Porton");
        productosNoAceptados.add("Ventanas");

    }

    public boolean puedeFabricar(Producto producto) {
        return producto.getAncho() <= 120 && producto.getAlto() <= 120 && materialesAceptados.contains(producto.getMaterial());
    }

    @Override
    public boolean UsarMaquina(Producto producto) {
        if(this.uso){
            return false;
        }
        return this.uso = puedeFabricar(producto);
    }

    @Override
    public boolean enUso() {
        return this.uso;
    }
}
