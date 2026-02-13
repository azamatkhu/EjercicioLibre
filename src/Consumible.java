import java.util.Random;

public class Consumible extends Objeto {
    private String tipoDeConsumible;

    public Consumible(String nombre, int cantidad, String tipoDeConsumible) {
        super(nombre, cantidad);
        this.tipoDeConsumible = tipoDeConsumible;
    }

    public String getTipoDeConsumible() {
        return tipoDeConsumible;
    }

    public void setTipoDeConsumible(String tipoDeConsumible) {
        this.tipoDeConsumible = tipoDeConsumible;
    }

    @Override
    public void utilizar() {
        super.utilizar();

        Random r = new Random();
        int puntosDeVida = r.nextInt(100);

        switch(tipoDeConsumible) {
            case "salud":
                System.out.println("Has recuperado " + puntosDeVida + " puntos de vida!");
                break;
            case "veneno":
                System.out.println("Has perdido " + puntosDeVida + " puntos de vida!");
                break;
            default:
                System.out.println("Has consumido algo raro!");
                break;
        }

        setCantidad(getCantidad() - 1);
    }

    @Override
    public String pasarAData() {
        return "CONSUMIBLE;" + getNombre() + ";" + getCantidad() + ";" + tipoDeConsumible;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Tipo de Consumible: " + tipoDeConsumible);
    }
}
