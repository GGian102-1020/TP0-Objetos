public class Ventana extends Producto{
    private String tipo;

    public Ventana(String material, double precio, String tipo) {
        super(material, precio);
        this.tipo = tipo;
    }

    @Override
    public void fabricar() {
        //
    }

    public double calcularCostoFabricacion() {
        //ACA VA LA FORMULA PARA CALCULAR LOS COSTOS

        //Ejemplo del costo se calcula que del precio total es la mitad
        double costo = (getPrecio() * 0.3) + 60;
        return costo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Material: " + getMaterial());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Tipo: " + tipo);
    }


}
