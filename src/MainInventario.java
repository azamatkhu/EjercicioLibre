import java.util.*;
import java.io.*;

public class MainInventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        System.out.println("Bienvenidos a Inventario");

        List<Objeto> objetos = LeerArchivo.leer("objetos.txt");
        Inventario inventario = new Inventario(objetos, 5);

        for (Objeto objeto : objetos) {
            inventario.setEspacioOcupado(inventario.getEspacioOcupado() + 1);
        }

        while(opcion != 0){
            System.out.println("-------- MENU ------------");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Utilizar objeto");
            System.out.println("3. Eliminar objeto");
            System.out.println(" ");
            System.out.println("4. Añadir objeto");
            System.out.println("5. Guardar Inventario");
            System.out.println(" ");
            System.out.println("0. Salir");
            System.out.println("-------- MENU ------------");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    int i = 0;

                    for (Objeto objeto : objetos){
                        System.out.println(i++);
                        objeto.mostrar();
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    System.out.println("Di el numero de objeto que quieres utilizar ");
                    int objetoNumero = sc.nextInt();

                    if (objetoNumero < 0 || objetoNumero > objetos.size() - 1 ) {
                        System.out.println("El numero no es valido!");
                        break;
                    }

                    objetos.get(objetoNumero).utilizar();
                    inventario.comprobarObjetosUtilizados();
                    break;
                case 3:
                    System.out.println("Di el numero de objeto que quieres eliminar ");
                    int objetoNum = sc.nextInt();

                    if (objetoNum < 0 || objetoNum > objetos.size() - 1 ) {
                        System.out.println("El numero no es valido!");
                        break;
                    }

                    inventario.eliminarObjeto(objetoNum);
                    break;
                case 5:
                    GuardarFichero.guardar("objetos.txt", objetos);
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("No es opcion valida!");
                    break;
            }
        }
    }
}