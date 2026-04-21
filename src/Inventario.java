import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Objeto> objetos = new ArrayList<Objeto>();
    private int espacioMaximo = 5;
    private int espacioOcupado;

    public Inventario(List<Objeto> objetos, int espacioMaximo) {
        this.espacioMaximo = espacioMaximo;
        this.objetos = objetos;
    }

    public void anadirObjeto(Objeto objeto) {
        if (espacioOcupado >= espacioMaximo) {
            System.out.println("No se puede añadir nuevo objeto! Inventario esta lleno!");
            return;
        }

        objetos.add(objeto);
        espacioOcupado++;
    }

    public void comprobarObjetosUtilizados() {
        for (int i = 0; i < objetos.size(); i++) {
            Objeto objeto = objetos.get(i);

            if (objeto.getCantidad() <= 0 || (objeto instanceof Herramienta && ((Herramienta) objeto).getPorcentajeDeUso() <= 0)) {
                eliminarObjeto(i);
                i--;
            }
        }
    }

    public void eliminarObjeto(int posicion) {
        if (posicion >= 0 && posicion < objetos.size()) {
            System.out.println("Objeto eliminado: " + objetos.get(posicion).getNombre());

            objetos.remove(posicion);
            espacioOcupado--;
        }
    }

    public int getEspacioMaximo() {
        return espacioMaximo;
    }

    public void setEspacioMaximo(int espacioMaximo) {
        this.espacioMaximo = espacioMaximo;
    }

    public int getEspacioOcupado() {
        return espacioOcupado;
    }

    public void setEspacioOcupado(int espacioOcupado) {
        this.espacioOcupado = espacioOcupado;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
}
