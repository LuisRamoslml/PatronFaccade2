/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

/**
 *
 * @author Home
 */
public class MatriculaBean {
    private int idmatricula;
    private String seccion;
    private String grado;
    private int idadmin;
    private int idalumno;
    private String nombrealumno;
 public MatriculaBean(){
     
 }

    public MatriculaBean(int idmatricula) {
        this.idmatricula = idmatricula;
    }
   
    
 
    
    

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }



    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    @Override
    public String toString() {
        return String.valueOf(idmatricula); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
