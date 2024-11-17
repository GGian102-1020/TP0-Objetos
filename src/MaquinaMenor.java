public class MaquinaMenor extends Maquina {

    public MaquinaMenor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }

    public boolean puedeFabricar(Producto producto) {
        return producto.getAncho() <= 120 && producto.getAlto() <= 120;
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
