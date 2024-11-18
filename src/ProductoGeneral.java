import java.util.ArrayList;
import java.util.List;

public class ProductoGeneral extends Producto {
    private int n;


    public ProductoGeneral(String nombre, double alto, double ancho, String material) {
        super(nombre, alto, ancho, material);
        n=0;
        this.estado = (estados.get(n));
    }

    @Override
    public boolean verificarProduccion(Maquina maquina) {
        return maquina.puedeFabricar(this);
    }
    public void usarMaquina(Maquina maquina) {
        if (maquina.puedeFabricar(this) && !maquina.enUso()){
            this.estado=(estados.get(n+1));

        }

    };
}