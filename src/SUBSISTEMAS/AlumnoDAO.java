/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBSISTEMAS;

import BEAN.AlumnoBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class AlumnoDAO {
     Connection cn=null;
    PreparedStatement pt=null;
    public static ArrayList<AlumnoBean>lista;
      public static ArrayList<AlumnoBean>listaadmin;
        public static ArrayList<AlumnoBean>listaalumno;
    AlumnoBean obj=null;
    public static AlumnoBean obj1=null;
    ResultSet rs=null;
      public static int CODIGO = 0;
    public ArrayList<AlumnoBean> ListarAlumno() {
  try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from alumno");
            rs = pt.executeQuery();
            lista = new ArrayList();
            while(rs.next())
            {
                obj = new AlumnoBean();
                obj.setIdalumno(rs.getInt(1));
                obj.setNombres(rs.getString(2));
                obj.setDni(rs.getString(3));
                obj.setCorreo(rs.getString(4));
                obj.setTelefono(rs.getString(5));
                obj.setDireccion(rs.getString(6));
          
                obj.setEstado(rs.getString(7));
               lista.add(obj);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;      }

   

    public int AgregarAlumno(AlumnoBean obj) {
 int i = 0;
        try
        {
              
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("INSERT INTO alumno VALUES (?,?,?,?,?,?,?);");
            pt.setInt(1, obj.getIdalumno());
            pt.setString(2, obj.getNombres());
             pt.setString(3, obj.getDni());
              pt.setString(4, obj.getCorreo());
               pt.setString(5, obj.getTelefono());
                   pt.setString(6, obj.getDireccion());
    
             pt.setString(7, obj.getEstado());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;     }

    public int ModificarAlumno(AlumnoBean obj) {
int i = 0;
        try
        {
              
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("update  alumno set nombres=?,dni=?,correo=?,telefono=?,direccion=?,estado=? where idalumno=?");
         
            pt.setString(1, obj.getNombres());
             pt.setString(2, obj.getDni());
              pt.setString(3, obj.getCorreo());
               pt.setString(4, obj.getTelefono());
                   pt.setString(5, obj.getDireccion());
      
             pt.setString(6, obj.getEstado());
                pt.setInt(7, obj.getIdalumno());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;       }

    public int EliminarAlumno(AlumnoBean obj) {
 int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM alumno WHERE idalumno=?;");
            pt.setInt(1, obj.getIdalumno());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;      }

    public int GenerarCodigoAlumno() {

        try {
              cn  =  ConexionBD.getConexionBD();
              pt  = cn.prepareStatement("SELECT MAX(idalumno) FROM alumno;");  
              rs=pt.executeQuery();
              rs.next();
              int c=Integer.parseInt(rs.getString(1))+1;
              String id="";
              if(c<10000000){id=""+c;}
              CODIGO=Integer.parseInt(id);
        } catch (Exception e) {
        }
        return CODIGO;      }

    public AlumnoBean CargarAlumno(AlumnoBean obj) {
try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from alumno where idalumno="+obj.getIdalumno());
            rs = pt.executeQuery();
            while(rs.next())
            {
                obj1 = new AlumnoBean();
                obj1.setIdalumno(rs.getInt(1));
                obj1.setNombres(rs.getString(2));
                obj1.setDni(rs.getString(3));
                obj1.setCorreo(rs.getString(4));
                obj1.setTelefono(rs.getString(5));
                obj1.setDireccion(rs.getString(6));

                obj1.setEstado(rs.getString(7));
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return obj1  ;  }


}
