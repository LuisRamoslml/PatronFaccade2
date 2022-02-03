
package BEAN;


public class SecretariaBean 
{
    private int idsecretaria;
    private String nombre;
    private String dni;
    private String usuario;
    private String clave;

    public SecretariaBean(int idsecretaria, String nombre) {
        this.idsecretaria = idsecretaria;
        this.nombre = nombre;
    }

    public SecretariaBean() {
        
    }

    public int getIdsecretaria() {
        return idsecretaria;
    }

    public void setIdsecretaria(int idsecretaria) {
        this.idsecretaria = idsecretaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
