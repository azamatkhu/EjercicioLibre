import java.util.Random;
import java.math.*;

public class Herramienta extends Objeto{
    private double porcentajeDeUso = 100.0;
    private String obtenido = "";

    public Herramienta(String nombre, int cantidad, double porcentajeDeUso, String obtenido) {
        super(nombre, cantidad);
        this.porcentajeDeUso = porcentajeDeUso;
        this.obtenido = obtenido;
    }

    public double getPorcentajeDeUso() {
        return porcentajeDeUso;
    }

    public void setPorcentajeDeUso(double porcentajeDeUso) {
        this.porcentajeDeUso = porcentajeDeUso;
    }

    @Override
    public void utilizar() {
        super.utilizar();
        Random r = new Random();

        porcentajeDeUso -= r.nextDouble(30);

        porcentajeDeUso = Math.round(porcentajeDeUso);

        if (porcentajeDeUso <= 0) {
            System.out.println(getNombre() + " se ha roto!");
        } else {
            System.out.println("Has obtenido " + obtenido);
        }
    }

    @Override
    public String pasarAData() {
        return "HERRAMIENTA;" + getNombre() + ";" + getCantidad() + ";" + porcentajeDeUso + ";" + obtenido;
    }

    @Override
    public void mostrar() {
        super.mostrar();

        System.out.println("Porcentaje del uso: " + porcentajeDeUso);
        System.out.println("Que obtiene: " + obtenido);
    }
}
