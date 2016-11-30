package personadb;

public class PersonaModel {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    private String nombre;
    private String apellido;
    private int idpersona;

    /**
     * @return the idpersona
     */
    public int getIdpersona() {
        return idpersona;
    }

    /**
     * @param idpersona the idpersona to set
     */
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
}
