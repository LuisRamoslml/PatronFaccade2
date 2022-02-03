/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBSISTEMAS;

import BEAN.DetalleMastriculaBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class DetalleMatriculaDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    public static ArrayList<DetalleMastriculaBean>lista;
      public static ArrayList<DetalleMastriculaBean>listamatricula;
        public static ArrayList<DetalleMastriculaBean>listacursos;
    DetalleMastriculaBean obj=null;
    public static DetalleMastriculaBean obj1=null;
    ResultSet rs=null;
      public static int CODIGO = 0;
    public ArrayList<DetalleMastriculaBean> ListarDetalleMatricula() {
 try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT d.idmatricula,c.idcurso,c.nombre from detallematricula d inner JOIN matricula m on m.idmatricula=d.idmatricula INNER join curso c on c.idcurso=d.idcurso");
            rs = pt.executeQuery();
            lista = new ArrayList();
            while(rs.next())
            {
                obj = new DetalleMastriculaBean();
                obj.setIdmatricula(rs.getInt(1));
                obj.setIdcurso(rs.getInt(2));
                obj.setNombcurso(rs.getString(3));
           
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

    public ArrayList<DetalleMastriculaBean> cargarCurso() {
 try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select * from curso");
            rs = pt.executeQuery();
            listacursos = new ArrayList();
            while(rs.next())
            {
                obj = new DetalleMastriculaBean();
          
                obj.setIdcurso(rs.getInt(1));
                obj.setNombcurso(rs.getString(2));
           
               listacursos.add(obj);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        } return listacursos;
    }

    public ArrayList<DetalleMastriculaBean> ListarMatricula() {
try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("select idmatricula from matricula");
            rs = pt.executeQuery();
            listamatricula = new ArrayList();
            while(rs.next())
            {
                obj = new DetalleMastriculaBean();
          
                obj.setIdmatricula(rs.getInt(1));
           
               listamatricula.add(obj);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        } return listamatricula;    }

    public int AgregarDetalleMatricula(DetalleMastriculaBean obj) {
  int i = 0;
        try
        {
              
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("INSERT INTO detallematricula VALUES (?,?);");
            pt.setInt(1, obj.getIdmatricula());
            pt.setInt(2, obj.getIdcurso());
            
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;      }

    public int ModificarDetalleMatricula(DetalleMastriculaBean obj) {
int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("UPDATE detallematricula set  idmatricula=? ,idcurso=? where idmatricula=? ");
           
               pt.setInt(1, obj.getIdmatricula());
               pt.setInt(2, obj.getIdcurso());
   pt.setInt(3, obj.getIdmatricula());

            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;      }

    
    public int EliminarDetalleMatricula(DetalleMastriculaBean obj) {
 int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM detallematricula WHERE idmatricula=? and idcurso=?;");
            pt.setInt(1, obj.getIdmatricula());
                pt.setInt(2, obj.getIdcurso());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;      }

    public DetalleMastriculaBean CargarDetalleMatricula(DetalleMastriculaBean obj) {
 try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT d.idmatricula,c.idcurso,c.nombre from detallematricula d inner JOIN matricula m on m.idmatricula=d.idmatricula INNER join curso c on c.idcurso=d.idcurso where d.idmatricula="+obj.getIdmatricula()+" and c.idcurso="+obj.getIdcurso());
            rs = pt.executeQuery();
            lista = new ArrayList();
            while(rs.next())
            {
                obj1 = new DetalleMastriculaBean();
                obj1.setIdmatricula(rs.getInt(1));
                obj1.setIdcurso(rs.getInt(2));
                obj1.setNombcurso(rs.getString(3));
           
               lista.add(obj);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return obj1;    }
}
