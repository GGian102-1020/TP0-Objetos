import java.util.Scanner;

public class Menu implements MenuA{
    private int password = 2430;
    private int PassIngresada;
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

            case 2:
                System.out.println("Ingrese la contraseña: ");
                int PassIngresada= scanner.nextInt();
                if (PassIngresada==password){
                    System.out.println("1. Ver pedidos por cliente");
                    System.out.println("2. Ver cola por máquinas");
                    opcion= scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Bien, funciona!");


                    }
                }

                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}


