/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBSISTEMAS;

import BEAN.MatriculaBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class MatriculaDAO {
  Connection cn=null;
    PreparedStatement pt=null;
    public static ArrayList<MatriculaBean>lista;
      public static ArrayList<MatriculaBean>listaadmin;
        public static ArrayList<MatriculaBean>listaalumno;
    MatriculaBean obj=null;
    public static MatriculaBean obj1=null;
    ResultSet rs=null;
      public static int CODIGO = 0;
      
    public ArrayList<MatriculaBean> ListarMatricula() {
   try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT m.idmatricula,m.seccion,m.grado,m.idalumno,al.nombres FROM matricula m  inner join alumno al on al.idalumno=m.idalumno");
            rs = pt.executeQuery();
            lista = new ArrayList();
            while(rs.next())
            {
                obj = new MatriculaBean();
                obj.setIdmatricula(rs.getInt(1));
                obj.setSeccion(rs.getString(2));
                obj.setGrado(rs.getString(3));
                obj.setIdalumno(rs.getInt(4));
                obj.setNombrealumno(rs.getString(5));
               lista.add(obj);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;    }

    public int AgregarMatricula(MatriculaBean obj) {
   int i = 0;
        try
        {
              
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("INSERT INTO matricula VALUES (?,?,?,?);");
            pt.setInt(1, obj.getIdmatricula());
            pt.setString(2, obj.getSeccion());
             pt.setString(3, obj.getGrado());
              pt.setInt(4, obj.getIdalumno());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;    }

    public int ModificarMatricula(MatriculaBean obj) {
  int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("UPDATE matricula SET seccion=?,grado=?,idalumno=? WHERE idmatricula=?;");
            pt.setString(1, obj.getSeccion());
             pt.setString(2, obj.getGrado());
               pt.setInt(3, obj.getIdalumno());
               pt.setInt(4, obj.getIdmatricula());

            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;    }

    public int EliminarMatricula(MatriculaBean obj) {
  int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM matricula WHERE idmatricula=?;");
            pt.setInt(1, obj.getIdmatricula());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;    }

    public int GenerarCodigoMatricula() {
 
        try {
              cn  =  ConexionBD.getConexionBD();
              pt  = cn.prepareStatement("SELECT MAX(idmatricula) FROM matricula ;");  
              rs=pt.executeQuery();
              rs.next();
              int c=Integer.parseInt(rs.getString(1))+1;
              String id="";
              if(c<10000000){id=""+c;}
              CODIGO=Integer.parseInt(id);
        } catch (Exception e) {
        }
        return CODIGO;     }



    public ArrayList<MatriculaBean> ListarAlumnos() {
try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT al.idalumno,al.nombres FROM alumno al left join matricula m on al.idalumno=m.idalumno where  m.idalumno is null");
            rs = pt.executeQuery();
            listaalumno = new ArrayList();
            while(rs.next())
            {
                obj = new MatriculaBean();
                obj.setIdalumno(rs.getInt(1));
                obj.setNombrealumno(rs.getString(2));
               listaalumno.add(obj);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return listaalumno;       }

    public MatriculaBean CargarMatricula(MatriculaBean obj) {
try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT m.idmatricula,m.seccion,m.grado,m.idalumno,al.nombres FROM matricula m  inner join alumno al on al.idalumno=m.idalumno where idmatricula="+obj.getIdmatricula());
            rs = pt.executeQuery();
            while(rs.next())
            {
                obj1 = new MatriculaBean();
                obj1.setIdmatricula(rs.getInt(1));
                obj1.setSeccion(rs.getString(2));
                obj1.setGrado(rs.getString(3));
                obj1.setIdalumno(rs.getInt(4));
                obj1.setNombrealumno(rs.getString(5));
               
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return obj1;
    }  
}
