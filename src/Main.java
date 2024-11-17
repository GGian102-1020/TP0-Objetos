//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MaquinaMenor A= new MaquinaMenor("Prueba",10);
        Producto Ab = new PuertaPrueba("Porton",120,120,"Madera");
        System.out.println(A.puedeFabricar(Ab));
        System.out.println(A.UsarMaquina(Ab));
        System.out.println(A.enUso());

    }
}