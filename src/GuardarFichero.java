import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardarFichero {
    public static void guardar(String fichero, List<Objeto> objetos) {
        System.out.println("Guardando...");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
            for (Objeto objeto : objetos) {
                String linea = "";

                writer.write(objeto.pasarAData());
                writer.newLine();
            }

            System.out.println("Fichero guardado con éxito.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
