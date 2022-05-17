package Modelo;

public class Login {

    private int id_login;
    private String usuario;
    private String contrasenya;
    private String tipo_persona; // Admin o user

    public Login(int id_login, String usuario, String contrasenya, String tipo_persona) {
        this.id_login = id_login;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.tipo_persona = tipo_persona;
    }

    public Login() {
    }

    /**
     * Creamos el getter de id_login
     * @return id_login
     */

    public int getId_login() {
        return id_login;
    }

    /**
     * Creamos un setter para id_login
     * @param id_login
     */

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    /**
     * Creamos el getter para el usuario
     * @return usuario
     */

    public String getUsuario() {
        return usuario;
    }

    /**
     * Creamos el setter para el usuario
     * @param usuario
     */

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Creamos el getter para la contrasenya
     * @return contrasenya
     */

    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Creamos el setter para la contrasenya
     * @param contrasenya
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    /**
     * Creamos el getter para el tipo_persona
     * @return tipo_persona
     */
    public String getTipo_persona() {
        return tipo_persona;
    }


    /**
     * Creamos el setter para tipo_persona
     * @param tipo_persona
     */
    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    /**
     * Creamos el metodo para dar de lata un usuario o admin
     */

    public void darDeAlta(){}

    /**
     * Creamos el metodo para inciar sesion de un usuario
     */
    public void inciarSesion(){}

    /**
     * Creamos el metodo para buscar un usuario si existe o no
     */
    public  void buscarUsuario(){}
}
