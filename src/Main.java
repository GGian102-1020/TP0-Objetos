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
        MaquinaMayor maquinaMayor = new MaquinaMayor("B", 500);

        do {
            menu.mostrar();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer después de leer un entero

            switch (opcion) {
                case 1: // Menú de cliente
                    int subOpcion = 0;
                    while (subOpcion != 3) {
                        System.out.println("1. Crear cliente");
                        System.out.println("2. Acceder a un cliente");
                        System.out.println("3. Volver atrás");
                        subOpcion = scanner.nextInt();
                        scanner.nextLine(); // Limpia el buffer después de leer un entero

                        switch (subOpcion) {
                            case 1: // Crear cliente
                                System.out.println("Ingresar el nombre de cliente: ");
                                String NombreCliente = scanner.nextLine();

                                // Validar entrada
                                while (NombreCliente.isBlank()) {
                                    System.out.println("El nombre no puede estar vacío. Intente de nuevo:");
                                    NombreCliente = scanner.nextLine();
                                }

                                // Generar un número de cliente único
                                while (clientes.containsKey(nroCliente) || nroCliente == 0) {
                                    Random random = new Random();
                                    nroCliente = random.nextInt(99) + 1;
                                }

                                // Crear el HashMap de cliente con nombre y valor
                                clientesInfo.put(NombreCliente, 0);
                                clientes.put(nroCliente, clientesInfo);
                                System.out.println("Cliente agregado con éxito con el número de cliente asignado: " + nroCliente);
                                nroCliente = 0;
                                break;

                            case 2: // Acceder a un cliente
                                try {
                                    System.out.println("Ingrese el número de cliente: ");
                                    nroCliente = scanner.nextInt();
                                    scanner.nextLine(); // Limpia el buffer después de leer un entero

                                    if (clientes.containsKey(nroCliente)) {
                                        System.out.println("Bienvenido " + clientes.get(nroCliente));
                                        System.out.println("¿Qué quieres saber hoy?");
                                        System.out.println("1. Estado de productos");
                                        System.out.println("2. Deuda");
                                        System.out.println("3. Hacer un pedido");
                                        System.out.println("4. Salir");

                                        int subSubOpcion = scanner.nextInt();
                                        scanner.nextLine(); // Limpia el buffer después de leer un entero

                                        while (subSubOpcion != 4) {
                                            switch (subSubOpcion) {
                                                case 1:
                                                    System.out.println("Estado de productos no implementado.");
                                                    break;
                                                case 2:
                                                    System.out.println("Consulta de deuda no implementada.");
                                                    break;
                                                case 3:
                                                    System.out.println("Realizar pedido no implementado.");
                                                    break;
                                                default:
                                                    System.out.println("Opción no válida.");
                                            }
                                            System.out.println("¿Qué más quieres hacer?");
                                            System.out.println("1. Estado de productos");
                                            System.out.println("2. Deuda");
                                            System.out.println("3. Hacer un pedido");
                                            System.out.println("4. Salir");
                                            subSubOpcion = scanner.nextInt();
                                            scanner.nextLine(); // Limpia el buffer después de leer un entero
                                        }
                                    } else {
                                        System.out.println("Cliente no encontrado.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Debe ingresar un número válido.");
                                    scanner.nextLine(); // Limpia el buffer
                                }
                                break;

                            case 3: // Volver atrás
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }
                    break;

                case 2: // Menú de administrador
                    intentos = 0;
                    while (intentos < 3) {
                        System.out.println("Ingrese la contraseña: ");
                        PassIngresada = scanner.nextInt();
                        scanner.nextLine(); // Limpia el buffer después de leer un entero

                        if (PassIngresada == password) {
                            System.out.println("Acceso permitido.");
                            int adminOpcion = 0;
                            while (adminOpcion != 3) {
                                System.out.println("1. Ver pedidos por cliente");
                                System.out.println("2. Ver cola por máquinas");
                                System.out.println("3. Volver atrás");
                                adminOpcion = scanner.nextInt();
                                scanner.nextLine(); // Limpia el buffer después de leer un entero

                                switch (adminOpcion) {
                                    case 1:
                                        System.out.println("Ver pedidos por cliente no implementado.");
                                        break;
                                    case 2:
                                        System.out.println("Ver cola por máquinas no implementado.");
                                        break;
                                    case 3:
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                        break;
                                }
                            }
                            break; // Salir del bucle de intentos
                        } else {
                            intentos++;
                            if (intentos == 3) {
                                System.out.println("Se quedó sin intentos. Cerrando el programa.");
                                return;
                            }
                            System.out.println("Contraseña incorrecta. Le quedan " + (3 - intentos) + " intentos.");
                        }
                    }
                    break;

                case 3: // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 3);
    }
}