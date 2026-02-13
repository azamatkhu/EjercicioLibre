public class Objeto {
    private String nombre;
    private int cantidad;

    public Objeto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void utilizar(){
        System.out.println("Has utilizado el objeto " + nombre);
    }

    public String pasarAData(){
        return "OBJETO;" + getNombre() + ";" + getCantidad();
    }

    public void mostrar(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cantidad: " + getCantidad());
    }
}
