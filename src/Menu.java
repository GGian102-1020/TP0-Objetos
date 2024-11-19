import java.util.*;

public class Menu implements MenuA {
    private int intentos = 0;
    private int password = 2430;
    private int PassIngresada;
    int nroCliente = 0;
    HashMap<Integer, HashMap<String, Integer>> clientes = new HashMap<>();
    HashMap<String, Integer> clientesInfo = new HashMap<>();
    List<ProductoGeneral> productos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void mostrar() {
        System.out.println("Bienvenido al DEF Menu, elige una opción:");
        System.out.println("1. Cliente");
        System.out.println("2. Admin");
        System.out.println("3. Salir");
    }

    /*public void AgregarProductoPrueba(){
        productos.add(0,new ProductoGeneral("Puerta",100,100,"madera",10,100));
    }*/



        public List<ProductoGeneral> DevolverLista(){
                return productos;
        }

}




