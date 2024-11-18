//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Menu menu= new Menu();
        System.out.println("Bienvenido al menu DEF, seleccione una opción:");
        menu.ejecutarOpcion(2);
        MaquinaMenor A= new MaquinaMenor("Prueba",10);
        Producto Ab = new ProductoGeneral("Porton",120,120,"Madera");
        System.out.println(A.puedeFabricar(Ab));
        System.out.println(A.UsarMaquina(Ab));
        System.out.println(A.enUso());

        menu.ejecutarOpcion(1);
    }
}