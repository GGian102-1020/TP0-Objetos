import java.awt.im.InputContext;
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

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        MaquinaMenor maquinaMenor = new MaquinaMenor("A", 200);
        MaquinaMayor maquinaMayor = new MaquinaMayor("B",500);
        menu.mostrar();

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
                            try {
                                while (!clientes.containsKey(nroCliente)) {
                                    System.out.println("Ingrese el número de cliente: ");
                                    nroCliente = scanner.nextInt();
                                }
                                System.out.println("Bienvenido " + clientes.get(nroCliente));
                                System.out.println("¿Qué quieres saber hoy?");
                                System.out.println("1. Estado de productos");
                                System.out.println("2. Deuda");
                                System.out.println("3. Hacer un pedido");
                                System.out.println("4. Salir");
                                int subOpcion = scanner.nextInt();
                                while (subOpcion != 4) {
                                    switch (subOpcion) {
                                        case 1:
                                            for (int n = 0; n < ProductoGeneral.productos.size(); n++) {
                                                if (ProductoGeneral.productos.get(n).getNroCliente() == nroCliente) {
                                                    System.out.println(ProductoGeneral.productos.get(n).getNombre() + " : " + ProductoGeneral.productos.get(n).getEstado());

                                                }
                                            }
                                            System.out.println("¿Qué más puedo hacer por vos?");
                                            System.out.println("1. Estado de productos");
                                            System.out.println("2. Deuda");
                                            System.out.println("3. Hacer un pedido");
                                            System.out.println("4. Salir");
                                            subOpcion = scanner.nextInt();
                                            break;
                                        case 2:
                                            if (ProductoGeneral.getClientePrecioMap().containsKey(nroCliente)) {
                                                System.out.println(ProductoGeneral.getClientePrecioMap().get(nroCliente));
                                            }
                                            System.out.println("3. Salir");
                                            subOpcion = scanner.nextInt();
                                            break;
                                        case 3:
                                            System.out.println("Ingrese los datos para realizar el pedido");
                                            System.out.println("Nombre: ");
                                            String nombProducto = scanner.next();
                                            System.out.println("Alto: ");
                                            int altProducto = scanner.nextInt();
                                            System.out.println("Ancho: ");
                                            int anchProducto = scanner.nextInt();
                                            System.out.println("Material: ");
                                            String matProducto = scanner.next();
                                            System.out.println("Peso: ");
                                            int pesProducto = scanner.nextInt();
                                            ProductoGeneral ProductoNew = new ProductoGeneral(nombProducto, altProducto, anchProducto, matProducto, pesProducto);
                                            ProductoNew.setNroCliente(nroCliente);
                                            System.out.println("Producto cargado correctamente");
                                            System.out.println("Elija una nueva opción: ");
                                            System.out.println("1. Estado de productos");
                                            System.out.println("2. Deuda");
                                            System.out.println("3. Hacer un pedido");
                                            System.out.println("4. Salir");
                                            subOpcion = scanner.nextInt();
                                            scanner.nextLine();
                                            break;


                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Opción no válida");

                                    }
                                }
                            }
                            catch (InputMismatchException e){
                                System.out.println("Error en el formato");
                                nroCliente=0;
                                scanner.nextLine();
                            }
                    }
                }

            menu.mostrar();
            case 2:
                while (opcion != 3) {
                    System.out.println("Ingrese la contraseña: ");
                    PassIngresada = scanner.nextInt();
                    while (intentos < 3) {
                        if (PassIngresada == password) {
                            intentos = 0; // Reinicia intentos exitosos
                            System.out.println("1. Ver pedidos por cliente");
                            System.out.println("2. Ver cola por máquinas");
                            System.out.println("3. Volver atrás");
                            int opcionA = scanner.nextInt();
                            scanner.nextLine(); // Limpia el buffer para evitar problemas con nextLine()

                            while (opcionA != 3) {
                                switch (opcionA) {
                                    case 1:
                                        System.out.println("Ingrese el número de cliente: ");
                                        nroCliente = scanner.nextInt();
                                        scanner.nextLine(); // Limpia el buffer
                                        for (ProductoGeneral producto : ProductoGeneral.productos) {
                                            if (producto.getNroCliente() == nroCliente) {
                                                System.out.println(producto.getNombre());
                                                intentos=0;
                                            }
                                        }
                                        break;

                                    case 2:
                                        System.out.println("Ingrese el nombre de la máquina: ");
                                        String nombreMaquina = scanner.nextLine();

                                        // Verifica el nombre de la máquina y muestra la cola correspondiente
                                        if (nombreMaquina.equals(maquinaMenor.getNombre())) {
                                            System.out.println(maquinaMenor.getColaProcesos());
                                        } else if (nombreMaquina.equals(maquinaMayor.getNombre())) {
                                            System.out.println(maquinaMayor.getColaProcesos());
                                        } else {
                                            System.out.println("Nombre de máquina incorrecto.");
                                        }
                                        break;

                                    default:
                                        System.out.println("Opción no válida.");
                                        break;
                                }

                                // Mostrar el submenú nuevamente
                                System.out.println("1. Ver pedidos por cliente");
                                System.out.println("2. Ver cola por máquinas");
                                System.out.println("3. Volver atrás");
                                opcionA = scanner.nextInt();
                                scanner.nextLine(); // Limpia el buffer nuevamente
                            }

                            break; // Sale del bucle de intentos después de opciones correctas
                        } else {
                            intentos++;
                            if (intentos == 3) {
                                System.out.println("Se quedó sin intentos, cerrando el programa.");
                                return; // Sale del programa
                            }
                            System.out.println("Contraseña incorrecta, le quedan " + (3 - intentos) + " intentos más:");
                            PassIngresada = scanner.nextInt();
                        }
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







