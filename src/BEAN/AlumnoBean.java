package BEAN;

public class AlumnoBean
{
    private int idalumno;
    private String nombres;
    private String dni;
    private String correo;
    private String telefono;
    private String direccion;
    private String usuario;
    private String clave;
    private String nuevaclave;
    private String estado;

    public AlumnoBean() {
    }

    public AlumnoBean(int idalumno, String nombres) {
        this.idalumno = idalumno;
        this.nombres = nombres;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getNuevaclave() {
        return nuevaclave;
    }

    public void setNuevaclave(String nuevaclave) {
        this.nuevaclave = nuevaclave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return nombres;
    }
}
