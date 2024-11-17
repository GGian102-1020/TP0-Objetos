public class MaquinaMenor extends Maquina {

    public MaquinaMenor(String nombre, double costoOperacion) {
        super(nombre, costoOperacion);
    }

    public boolean puedeFabricar(Producto producto) {
        return producto.getAncho() <= 120 && producto.getAlto() <= 120;
    }

    @Override
    public boolean UsarMaquina(Producto producto) {
        return this.Uso = puedeFabricar(producto);
    }

    @Override
    public boolean enUso() {
        return this.Uso;
    }
}
