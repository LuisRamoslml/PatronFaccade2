package BEAN;

public class CursoBean
{
    private int idcurso;
    private String nombre;

    public CursoBean() {
    }

    public CursoBean(int idcurso, String nombre) {
        this.idcurso = idcurso;
        this.nombre = nombre;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
