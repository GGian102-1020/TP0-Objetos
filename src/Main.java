import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        menu.mostrar();
        int opcion;
        try {
            opcion = scanner.nextInt();
            menu.ejecutarOpcion(opcion);
        } catch (InputMismatchException exception) {
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Opción incorrecta, ingrese una opción numérica: ");
                    scanner.nextLine();
                }
            }



                    MaquinaMenor A = new MaquinaMenor("Prueba", 10);
                    Producto Ab = new ProductoGeneral("Porton", 120, 120, "Madera",30, 1000.5);
                    System.out.println(A.puedeFabricar(Ab));
                    System.out.println(A.fabricar(Ab));
                    System.out.println(A.enUso());
                }
            }
        }


