package Modelo;

public class Persona {

    private int id_personas;
    private String nombre;
    private String apellido;

    /**
     * Creamos el constructor de Persona
     * @param id_personas id de persona
     * @param nombre nombre
     * @param apellido apellido
     */

    public Persona(int id_personas, String nombre, String apellido) {
        this.id_personas = id_personas;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {

    }

    /**
     * Creamos el getter para id_personas
     * @return integer
     */
    public int getId_personas() {
        return id_personas;
    }

    /**
     * Creamos el setter para id_personas
     * @param id_personas id_persona
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
     * @param nombre nombre
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
     * @param apellido apelido
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
