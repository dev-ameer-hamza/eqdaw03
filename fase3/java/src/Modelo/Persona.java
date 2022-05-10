package Modelo;

public class Persona {

    private int id_personas;
    private String nombre;
    private String apellido;

    /**
     * Creamos el constructor de Persona
     * @param id_personas
     * @param nombre
     * @param apellido
     */

    public Persona(int id_personas, String nombre, String apellido) {
        this.id_personas = id_personas;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Creamos el getter para id_personas
     * @return
     */
    public int getId_personas() {
        return id_personas;
    }

    /**
     * Creamos el setter para id_personas
     * @param id_personas
     */
    public void setId_personas(int id_personas) {
        this.id_personas = id_personas;
    }

    /**
     * Creamos el getter para Nombre
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Creamos el setter para nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Creamos el getter para Apellido
     * @return apellido
     */

    public String getApellido() {
        return apellido;
    }

    /**
     * creamos el setter para apellido
     * @param apellido
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
