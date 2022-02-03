/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACHADA;

import BEAN.AlumnoBean;
import BEAN.CursoBean;
import BEAN.DetalleMastriculaBean;
import BEAN.HorarioBean;
import BEAN.MatriculaBean;
import BEAN.ProfesorBean;
import BEAN.SecretariaBean;
import SUBSISTEMAS.AlumnoDAO;
import SUBSISTEMAS.CuirsoDAO;
import SUBSISTEMAS.DetalleMatriculaDAO;
import SUBSISTEMAS.HorarioDAO;
import SUBSISTEMAS.MatriculaDAO;
import SUBSISTEMAS.ProfesorDAO;
import SUBSISTEMAS.SecretariaDAO;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class Fachada {
    int i=0;
    AlumnoBean objalumnobeanm=null;
    AlumnoDAO objalumnoDAO=null;
    
    CursoBean objcurso=null;
    CuirsoDAO objcursodao=null;
    
    DetalleMastriculaBean objdetallematriculabean=null;
    DetalleMatriculaDAO objdetallematriculadao=null;
    
    HorarioBean objhorraiobean=null;
    HorarioDAO objhorariodao=null;
    
    MatriculaBean objmatriculabean=null;
    MatriculaDAO objmatriculadao=null;
    
    ProfesorBean objprofesorbean=null;
    ProfesorDAO objprofesordao=null;
    
    SecretariaBean objsecretariabean=null;
    SecretariaDAO objsecretariadao=null;
    
    ArrayList<CursoBean> listacurso;
    ArrayList<AlumnoBean>listaalumnos;
    ArrayList<ProfesorBean>listaprofesor;
    ArrayList<DetalleMastriculaBean>listadetalle;
    ArrayList<HorarioBean>listahorario;
    ArrayList<MatriculaBean>listamatriculas;
    public ArrayList<CursoBean> listacursos(){
        objcursodao=new CuirsoDAO();
        listacurso=objcursodao.ListarCursos();
        
        return listacurso;
    }
     public int ValidarAcceso(SecretariaBean obj)
    {
        objsecretariadao=new SecretariaDAO();
        i=objsecretariadao.ValidarAcceso(obj);
        return i;
    }
    public  int generarcodigocurso(){
        objcursodao=new CuirsoDAO();
         i=objcursodao.GenerarCodigo();
        return i;
    }
    public  int eliminarcurso(CursoBean obj){
        objcursodao=new CuirsoDAO();
         i=objcursodao.EliminarCurso(obj);
        return i;
    }    
    
        public  int grabarcurso(CursoBean obj){
        objcursodao=new CuirsoDAO();
         i=objcursodao.AgregarCurso(obj);
        return i;
    }
        
            public  int modificarcurso(CursoBean obj){
        objcursodao=new CuirsoDAO();
         i=objcursodao.ModificarCurso(obj);
        return i;
    }
            
  public ArrayList<AlumnoBean> listaalumnos(){
        objalumnoDAO=new AlumnoDAO();
        listaalumnos=objalumnoDAO.ListarAlumno();
        
        return listaalumnos;
    }
    public  int generarcodigoalumno(){
        objalumnoDAO=new AlumnoDAO();
         i=objalumnoDAO.GenerarCodigoAlumno();
        return i;
    }
    public  int eliminaralumno(AlumnoBean obj){
        objalumnoDAO=new AlumnoDAO();
         i=objalumnoDAO.EliminarAlumno(obj);
        return i;
    }    
    
        public  int grabaralumno(AlumnoBean obj){
        objalumnoDAO=new AlumnoDAO();
         i=objalumnoDAO.AgregarAlumno(obj);
        return i;
    }
        
            public  int modiifcaralumno(AlumnoBean obj){
        objalumnoDAO=new AlumnoDAO();
         i=objalumnoDAO.ModificarAlumno(obj);
        return i;
    }
            
              public  AlumnoBean cargaralumno(AlumnoBean obj){
        objalumnobeanm=new AlumnoBean();
                  objalumnoDAO=new AlumnoDAO();
         objalumnobeanm=objalumnoDAO.CargarAlumno(obj);
        return objalumnobeanm;
    }

              
              
               public ArrayList<ProfesorBean> listaprofesor(){
        objprofesordao=new ProfesorDAO();
        listaprofesor=objprofesordao.MostrarProfesor();
        
        return listaprofesor;
    }
    public  int generarcodigoprofesor(){
        objprofesordao=new ProfesorDAO();
         i=objprofesordao.GenerarCodigo();
        return i;
    }
    public  int eliminarprofesor(ProfesorBean obj){
        objprofesordao=new ProfesorDAO();
         i=objprofesordao.EliminarProfesor(obj);
        return i;
    }    
    
        public  int grabarprofesor(ProfesorBean obj){
        objprofesordao=new ProfesorDAO();
         i=objprofesordao.GrabarProfesor(obj);
        return i;
    }
        
            public  int modificarprofesor(ProfesorBean obj){
        objprofesordao=new ProfesorDAO();
         i=objprofesordao.ModificarProfesor(obj);
        return i;
    }
            
              public  ProfesorBean cargarprofesor(ProfesorBean obj){
        objprofesorbean=new ProfesorBean();
                  objprofesordao=new ProfesorDAO();
         objprofesorbean=objprofesordao.CapturarDatos(obj);
        return objprofesorbean;
    }
              
                public ArrayList<MatriculaBean> listamatricula(){
        objmatriculadao=new MatriculaDAO();
        listamatriculas=objmatriculadao.ListarMatricula();
        
        return listamatriculas;
    }
                
                
                public ArrayList<MatriculaBean> listamatriculaalumno(){
        objmatriculadao=new MatriculaDAO();
        listamatriculas=objmatriculadao.ListarAlumnos();
        
        return listamatriculas;
    }
    public  int generarcodigomatricula(){
        objmatriculadao=new MatriculaDAO();
         i=objmatriculadao.GenerarCodigoMatricula();
        return i;
    }
    public  int eliminarmatricula(MatriculaBean obj){
        objmatriculadao=new MatriculaDAO();
         i=objmatriculadao.EliminarMatricula(obj);
        return i;
    }    
    
        public  int grabarmatricula(MatriculaBean obj){
        objmatriculadao=new MatriculaDAO();
         i=objmatriculadao.AgregarMatricula(obj);
        return i;
    }
        
            public  int modificarmatricula(MatriculaBean obj){
        objmatriculadao=new MatriculaDAO();
         i=objmatriculadao.ModificarMatricula(obj);
        return i;
    }
            
              public  MatriculaBean cargarmatricula(MatriculaBean obj){
        objmatriculabean=new  MatriculaBean();
                  objmatriculadao=new MatriculaDAO();
         objmatriculabean=objmatriculadao.CargarMatricula(obj);
        return objmatriculabean;
    }
              
                 public ArrayList<DetalleMastriculaBean> listadetalematricula(){
        objdetallematriculadao=new DetalleMatriculaDAO();
        listadetalle=objdetallematriculadao.ListarDetalleMatricula();
        
        return listadetalle;
    }
   
                 
                  public ArrayList<DetalleMastriculaBean> listadetalematriculaMATRICULAS(){
        objdetallematriculadao=new DetalleMatriculaDAO();
        listadetalle=objdetallematriculadao.ListarMatricula();
        
        return listadetalle;
    }
                  
                   public ArrayList<DetalleMastriculaBean> listadetalematriculaCURSOS(){
        objdetallematriculadao=new DetalleMatriculaDAO();
        listadetalle=objdetallematriculadao.cargarCurso();
        
        return listadetalle;
    }
    public  int eliminardetallematricula(DetalleMastriculaBean obj){
        objdetallematriculadao=new DetalleMatriculaDAO();
         i=objdetallematriculadao.EliminarDetalleMatricula(obj);
        return i;
    }    
    
        public  int grabardetallmatricula(DetalleMastriculaBean obj){
        objdetallematriculadao=new DetalleMatriculaDAO();
         i=objdetallematriculadao.AgregarDetalleMatricula(obj);
        return i;
    }
        
            public  int modificardetallematricula(DetalleMastriculaBean obj){
        objdetallematriculadao=new DetalleMatriculaDAO();
         i=objdetallematriculadao.ModificarDetalleMatricula(obj);
        return i;
    }
            
              public  DetalleMastriculaBean cargardetalle(DetalleMastriculaBean obj){
        objdetallematriculabean=new  DetalleMastriculaBean();
        objdetallematriculadao=new DetalleMatriculaDAO();
         objdetallematriculabean=objdetallematriculadao.CargarDetalleMatricula(obj);
        return objdetallematriculabean;
    }
              
              public ArrayList<HorarioBean> listahorario(){
        objhorariodao=new HorarioDAO();
        listahorario=objhorariodao.ListarHorarios();
        
        return listahorario;
    }
   
                  public ArrayList<HorarioBean> listahorariocursos(){
        objhorariodao=new HorarioDAO();
        listahorario=objhorariodao.CargarCursos();
        
        return listahorario;
    }    public ArrayList<HorarioBean> listahorarioprofesor(){
        objhorariodao=new HorarioDAO();
        listahorario=objhorariodao.CargarProfesor();
        
        return listahorario;
    }   
                
    public  int eliminarhorraio(HorarioBean obj){
        objhorariodao=new HorarioDAO();
         i=objhorariodao.EliminarHorario(obj);
        return i;
    }    
    
        public  int grabarhorario(HorarioBean obj){
        objhorariodao=new HorarioDAO();
         i=objhorariodao.AgregarHorario(obj);
        return i;
    }
        
            public  int modificarhorario(HorarioBean obj){
        objhorariodao=new HorarioDAO();
         i=objhorariodao.ModificarHorario(obj);
        return i;
    }
            
              public  HorarioBean  cargarhorario(HorarioBean obj){
        objhorraiobean =new HorarioBean();
        objhorariodao=new HorarioDAO();
         objhorraiobean=objhorariodao.CargarHorario(obj);
        return objhorraiobean;
    }
              
                  public  int generarcodigohorario(){
        objhorariodao=new HorarioDAO();
         i=objhorariodao.GenerarCodigo();
        return i;
    }
              
}
