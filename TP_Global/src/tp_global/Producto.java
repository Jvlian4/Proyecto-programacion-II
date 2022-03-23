package tp_global;

public class Producto {

    //Atributos
    protected String nombre;
    protected int precio;
    protected Local local;

    //Métodos
    public Producto(String nombre, int precio, Local local) { //Método constructor
        this.nombre = nombre;
        this.precio = precio;
        this.local = local;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
