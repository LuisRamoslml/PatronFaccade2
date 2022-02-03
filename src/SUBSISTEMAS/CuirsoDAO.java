/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBSISTEMAS;

import BEAN.CursoBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class CuirsoDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ArrayList<CursoBean> ListarCurso=null;
    CursoBean objCursoBean=null;
    
    public ArrayList<CursoBean> ListarCursos()
    {
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT * FROM curso;");
            rs = pt.executeQuery();
            ListarCurso = new ArrayList();
            while(rs.next())
            {
                objCursoBean = new CursoBean();
                objCursoBean.setIdcurso(rs.getInt(1));
                objCursoBean.setNombre(rs.getString(2));
                ListarCurso.add(objCursoBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return ListarCurso;
    }

    public int AgregarCurso(CursoBean obj)
    {
        int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("INSERT INTO curso VALUES (?,?)");
            pt.setInt(1, obj.getIdcurso());
            pt.setString(2, obj.getNombre());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;
    }
    
    public int ModificarCurso(CursoBean obj)
    {
        int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("UPDATE curso SET nombre=? WHERE idcurso=?");
            pt.setString(1, obj.getNombre());
            pt.setInt(2, obj.getIdcurso());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;
    }

    public int EliminarCurso(CursoBean obj)
    {
        int i = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM curso WHERE idcurso="+obj.getIdcurso());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            i = 0;
        }
        return i;
    }

    public int GenerarCodigo()
    {
        int cod = 0;
        try
        {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT MAX(idcurso) FROM curso;");  
            rs = pt.executeQuery();
            rs.next();
            int c = Integer.parseInt(rs.getString(1))+1;
            String id="";
            if(c<10000000)
            {
                id=String.valueOf(c);
            }
            cod=Integer.parseInt(id);
        } catch (Exception e)
        {
        }
        return cod;
    }
}
