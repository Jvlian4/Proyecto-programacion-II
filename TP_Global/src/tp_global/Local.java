package tp_global;

public class Local {

    //Atributos
    private String nombre;
    private String direccion;

    //Métodos
    public Local(String nombre, String direccion) { //Método constructor
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
