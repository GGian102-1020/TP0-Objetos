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
        Menu menu= new Menu();
        MaquinaMenor maquinaMenor= new MaquinaMenor("A",200);
        menu.mostrar();
        ProductoGeneral ProductoA= new ProductoGeneral("Puerta", 100, 100, "Madera", 10);
        ProductoGeneral ProductoB= new ProductoGeneral("Puerta", 100, 110, "Madera", 10);
        ProductoGeneral ProductoC= new ProductoGeneral("Ventana", 100, 110, "Madera", 10);
        maquinaMenor.fabricar(ProductoA);
        maquinaMenor.fabricar(ProductoB);
        maquinaMenor.fabricar(ProductoC);
        opcion=scanner.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("1. Crear numero de cliente");
                System.out.println("2. Ingresar numero de cliente");
                System.out.println("3. Volver atrás");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresar el nombre de cliente: ");
                        String NombreCliente = scanner.nextLine();
                        while (NombreCliente.isBlank()) {
                            NombreCliente = scanner.nextLine();
                        }


                        Random random = new Random();
                        while (clientes.containsKey(nroCliente) || nroCliente == 0) {
                            nroCliente = random.nextInt(99) + 1;
                        }
                        clientesInfo.put(NombreCliente, 0);
                        clientes.put(nroCliente, (clientesInfo));
                        System.out.println("Cliente agregado con éxito con el número de cliente asignado: " + nroCliente);
                        nroCliente = 0;
                        menu.ejecutarOpcion(1);

                    case 2:
                        while (!clientes.containsKey(nroCliente)) {
                            System.out.println("Ingrese el número de cliente: ");
                            nroCliente = scanner.nextInt();
                        }
                        System.out.println("Bienvenido " + clientes.get(nroCliente));
                        System.out.println("Qué quieres saber hoy? ");
                        System.out.println("1. Estado de productos");
                        System.out.println("2. Deuda");
                        System.out.println("3. Salir");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1:
                                Iterator<ProductoGeneral> iteracion = productos.iterator();
                                while (iteracion.hasNext()) {
                                    ProductoGeneral productoA= iteracion.next();
                                    if (productoA.getNroCliente() == nroCliente) {
                                        System.out.println(iteracion);
                                    }
                                }
                            case 2:
                            case 3:
                                break;
                            default:
                                System.out.println("Opcion no válida");
                        }


                    case 3:
                        break;
                    default:
                        System.out.println("Opción no válida");
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
                                intentos = 3;
                            case 2:
                                System.out.println("Cola por maquinas");
                                intentos = 3;
                                String nombreMaquina= scanner.nextLine();
                                if(maquinaMenor.getNombre() == nombreMaquina);

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
