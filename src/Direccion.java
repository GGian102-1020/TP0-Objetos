public class Direccion {
    private String calle;
    private String ciudad;
    private int codigoPostal;

    public Direccion (String calle, String ciudad, int codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public void mostrarDireccion() {
        System.out.println("La direccion de entrega es en: " + calle + "ubicada en: " + ciudad + codigoPostal);
    }
}
