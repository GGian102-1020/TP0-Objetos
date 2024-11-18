import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Menu implements MenuA{
    private int intentos = 0;
    private int password = 2430;
    private int PassIngresada;
    int nroCliente = 0;
    HashMap<Integer, String> clientes = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void mostrar() {
        System.out.println("Bienvenido al DEF Menu, elige una opción:");
        System.out.println("1. Cliente");
        System.out.println("2. Admin");
        System.out.println("3. Salir");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("1. Crear numero de cliente");
                System.out.println("2. Ingresar numero de cliente");
                System.out.println("3. Volver atrás");
                opcion=scanner.nextInt();
                switch(opcion) {
                    case 1:
                        System.out.println("Ingresar el nombre de cliente: ");
                        String NombreCliente = scanner.nextLine();
                        while (NombreCliente.isBlank()) {
                            NombreCliente = scanner.nextLine();
                        }


                        Random random = new Random();
                        while (clientes.containsKey(nroCliente) || nroCliente==0 ){
                            nroCliente= random.nextInt(99)+1;
                        }

                        clientes.put(nroCliente, NombreCliente);
                        System.out.println("Cliente agregado con éxito con el número de cliente asignado: " + nroCliente);

                    case 2:
                        nroCliente= scanner.nextInt();
                        while(!clientes.containsKey(nroCliente)){
                            System.out.println("Ingrese el número de cliente correctamente: ");
                            nroCliente= scanner.nextInt();
                        }
                        //for n in range(0, len(ListaClientes))
                        // if(
                        // ListaClientes[n][1]==nroCliente)
                        // sout


                    case 3:
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            case 2:
                System.out.println("Ingrese la contraseña: ");
                int PassIngresada= scanner.nextInt();
                while (intentos<2)
                if (PassIngresada==password){
                    intentos+=1;
                    System.out.println("1. Ver pedidos por cliente");
                    System.out.println("2. Ver cola por máquinas");
                    System.out.println("3. Volver atrás");
                    int opcionA= scanner.nextInt();
                    switch (opcionA) {
                        case 1:
                            System.out.println("Ingrese el número de cliente: ");
                            int nCliente= scanner.nextInt();
                            intentos=3;
                        case 2:
                            System.out.println("Cola por maquinas");
                            intentos=3;
                        case 3:
                            break;

                    }
                }
                else{
                    intentos+=1;
                    System.out.println("Contraseña incorrecta, le quedan " + (3-intentos) + " intentos más:");
                    PassIngresada= scanner.nextInt();
                }

                break;
            case 3:
                break;

            default:
                System.out.println("Opción no válida");
        }
    }
}


