
package tp_global;

public class Cliente {

    //Atributos
    private String nombre;
    private String contra;
    private int rol;

    //Métodos
    public Cliente(String nombre, String contra, int rol) { //Método cosntructor

        this.nombre = nombre;
        this.contra = contra;
        this.rol = rol;

    }

    public Cliente() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getContra() {
        return contra;
    }

    public int getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
}
