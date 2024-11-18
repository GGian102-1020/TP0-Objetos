import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int intentos = 0;
        int password = 2430;
        int PassIngresada;
        int opcion;
        int nroCliente = 0;
        HashMap<Integer, HashMap<String, Integer>> clientes = new HashMap<>();
        HashMap<String, Integer> clientesInfo = new HashMap<>();
        List<ProductoGeneral> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        MaquinaMenor maquinaMenor = new MaquinaMenor("A", 200);
        menu.mostrar();
        ProductoGeneral ProductoA = new ProductoGeneral("Puerta", 100, 100, "Madera", 10);
        ProductoGeneral ProductoB = new ProductoGeneral("Puerta", 100, 110, "Madera", 10);
        ProductoGeneral ProductoC = new ProductoGeneral("Ventana", 100, 110, "Madera", 10);
        ProductoA.setNroCliente(23);
        ProductoB.setNroCliente(23);
        productos.add(ProductoA);
        productos.add(ProductoB);
        productos.add(ProductoC);
        System.out.println((productos.get(1).getEstado()));
        maquinaMenor.fabricar(ProductoA);
        maquinaMenor.fabricar(ProductoB);
        maquinaMenor.fabricar(ProductoC);
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                while(opcion!=3) {
                    System.out.println("1. Crear cliente");
                    System.out.println("2. Acceder a un cliente");
                    System.out.println("3. Volver atrás");
                    opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            // Opción 1: Agregar un cliente
                            System.out.println("Ingresar el nombre de cliente: ");
                            String NombreCliente = scanner.nextLine();
                            while (NombreCliente.isBlank()) {
                                NombreCliente = scanner.nextLine();
                            }
                            // Generar un número de cliente único
                            while (clientes.containsKey(nroCliente) || nroCliente == 0) {
                                Random random = new Random();
                                nroCliente = 23;//random.nextInt(99) + 1;
                            }


                            // Crear el HashMap de cliente con nombre y valor
                            clientesInfo.put(NombreCliente, 0);
                            clientes.put(nroCliente, clientesInfo);
                            System.out.println("Cliente agregado con éxito con el número de cliente asignado: " + nroCliente);
                            nroCliente = 0;
                            break;
                        case 2:
                            // Opción 2: Acceder a un cliente
                            while (!clientes.containsKey(nroCliente)) {
                                System.out.println("Ingrese el número de cliente: ");
                                nroCliente = scanner.nextInt();
                            }
                            System.out.println("Bienvenido " + clientes.get(nroCliente));
                            System.out.println("¿Qué quieres saber hoy?");
                            System.out.println("1. Estado de productos");
                            System.out.println("2. Deuda");
                            System.out.println("3. Salir");
                            int subOpcion = scanner.nextInt();
                            switch (subOpcion) {
                                case 1:
                                    System.out.println(subOpcion);
                                    for (int n = 0; n < productos.size(); n++) {
                                        if (productos.get(n).getNroCliente() == nroCliente) {
                                            System.out.println(productos.get(n).getNombre() +" : " + productos.get(n).getEstado());

                                        }
                                    }
                                    break;
                                case 2:
                                    // Código para ver deuda
                                    System.out.println("Deuda...");
                                    break;
                                case 3:
                                    // Salir
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                            break;
                        case 3:
                            break;
                    }
                }

            case 2:
                System.out.println("Ingrese la contraseña: ");
                PassIngresada = scanner.nextInt();
                while (intentos < 2)
                    if (PassIngresada == password) {
                        intentos += 1;
                        System.out.println("1. Ver pedidos por cliente");
                        System.out.println("2. Ver cola por máquinas");
                        System.out.println("3. Volver atrás");
                        int opcionA = scanner.nextInt();
                        switch (opcionA) {
                            case 1:
                                System.out.println("Ingrese el número de cliente: ");
                                nroCliente = scanner.nextInt();
                                System.out.println(productos);
                                for (int n = 0; n < productos.size(); n++) {
                                    if (productos.get(n).getNroCliente() == nroCliente) {
                                        System.out.println(productos.get(n).getNombre());
                                    }
                                }
                                intentos = 3;
                            case 2:
                                System.out.println("Cola por maquinas");
                                intentos = 3;
                                String nombreMaquina = scanner.nextLine();
                                if (maquinaMenor.getNombre() == nombreMaquina) ;
                                System.out.println();
                                System.out.println(maquinaMenor.getColaProcesos());
                            case 3:
                                break;

                        }
                    } else {
                        intentos += 1;
                        System.out.println("Contraseña incorrecta, le quedan " + (3 - intentos) + " intentos más:");
                        PassIngresada = scanner.nextInt();
                        if (intentos == 2) {
                            System.out.println("Se quedó sin intentos, cerrando el programa");
                            break;
                        }
                    }

                break;
            case 3:
                break;

            default:
                System.out.println("Opción no válida, cerrando el menu");
        }
    }
}







