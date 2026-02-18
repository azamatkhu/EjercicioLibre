import java.util.*;
import java.io.*;

public class MainInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(new ArrayList<>(), 5);
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        List<Objeto> objetos = LeerArchivo.leer("objetos.txt");

        if (objetos.isEmpty()) {
            System.out.println("Archivo no encontrado");
            objetos.add(new Herramienta("Pico", 1, 100.0, "hierro"));
            objetos.add(new Consumible("Manzana", 5, "salud"));
        }

        inventario.setObjetos(objetos);

        for (Objeto objeto : inventario.getObjetos()) {
            inventario.setEspacioOcupado(inventario.getEspacioOcupado() + 1);
        }

        System.out.println("Bienvenidos a Inventario");

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

                    if (objetoNumero < 0 || objetoNumero > inventario.getObjetos().size()) {
                        System.out.println("El numero no es valido!");
                        break;
                    }

                    inventario.getObjetos().get(objetoNumero).utilizar();
                    inventario.comprobarObjetosUtilizados();
                    break;
                case 3:
                    System.out.println("Di el numero de objeto que quieres eliminar ");
                    int objetoNum = sc.nextInt();

                    if (objetoNum < 0 || objetoNum > inventario.getObjetos().size()) {
                        System.out.println("El numero no es valido!");
                        break;
                    }

                    inventario.eliminarObjeto(objetoNum);
                    break;
                case 4:
                    System.out.println("Que tipo de objeto quieres añadir (HERRAMIENTA o CONSUMIBLE): ");
                    String tipoObjeto = sc.nextLine();

                    System.out.println("Escribe el nombre de objeto: ");
                    String nombre = sc.nextLine();

                    System.out.println("Escribe el numero de cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    switch (tipoObjeto.toLowerCase()) {
                        case "herramienta":
                            System.out.println("Escribe el porcentaje del uso: ");
                            double porcentajeDeUso = sc.nextDouble();

                            System.out.println("Escribe que obtiene: ");
                            String obtiene = sc.nextLine();

                            inventario.anadirObjeto(new Herramienta(nombre, cantidad, porcentajeDeUso, obtiene));
                            break;
                        case "consumible":
                            System.out.println("Escribe que tipo de consumible: ");
                            String tipoDeConsumible = sc.nextLine();

                            inventario.anadirObjeto(new Consumible(nombre, cantidad, tipoDeConsumible));
                            break;
                        default:
                            System.out.println("Error!");
                            break;
                    }
                    break;
                case 5:
                    GuardarFichero.guardar("objetos.txt", inventario.getObjetos());
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