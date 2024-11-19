import java.util.List;
import java.util.*;

public abstract class Producto {
    private String nombre;
    private double alto;
    private double ancho;
    private String material;
    protected String estado;
    private static List<String> estados = new ArrayList<>(Arrays.asList("En espera", "En producción", "Terminado"));
    protected int nroCliente;

    public Producto(String nombre, double alto, double ancho, String material) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
    public double getAlto(){
        return alto;
    }

    public double getAncho(){
        return ancho;
    }

    public String getNombre(){
        return nombre;
    }
    public int getNroCliente(){
        return nroCliente;
    }
    public void setNroCliente(int Cliente){
        this.nroCliente=Cliente;
    }


    public abstract boolean verificarProduccion(Maquina maquina);



}
