import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {
    public static List<Objeto> leer(String archivo) {
        System.out.println("Leyendo fichero " + archivo + "...");

        List<Objeto> listaObjetos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");

                String tipo = partes[0];
                String nombre = partes[1];
                int cantidad = Integer.parseInt(partes[2]);

                if (tipo.equals("HERRAMIENTA")) {
                    double porcentaje = Double.parseDouble(partes[3]);
                    String obtenido = partes[4];

                    listaObjetos.add(new Herramienta(nombre, cantidad, porcentaje, obtenido));

                } else if (tipo.equals("CONSUMIBLE")) {
                    String tipoConsumible = partes[3];

                    listaObjetos.add(new Consumible(nombre, cantidad, tipoConsumible));
                } else {
                    listaObjetos.add(new Objeto(nombre, cantidad));
                }
            }

            System.out.println("Los objetos se han cargado! ");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaObjetos;
    }
}
