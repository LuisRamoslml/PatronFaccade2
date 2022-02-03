/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBSISTEMAS;

import BEAN.ProfesorBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class ProfesorDAO {
      Connection cn=null;
         ProfesorBean objbean=null;
         public static ArrayList<ProfesorBean> lista=null;
         PreparedStatement pt =null;
         ResultSet rs =null;
         public static int i = 0;
         public static ProfesorBean objcapturar=null;
    public ArrayList<ProfesorBean> MostrarProfesor( ) {
            try {
                ConexionBD objc=new ConexionBD();
              cn=objc.getConexionBD();
              pt=cn.prepareStatement("select * from profesor");
              rs=pt.executeQuery();
              lista=new ArrayList<ProfesorBean>();
              while(rs.next()){
              objbean=new ProfesorBean();
              objbean.setIdprofesor(rs.getInt(1));
              objbean.setNombres(rs.getString(2));
              objbean.setDni(rs.getString(3));
              objbean.setCorreo(rs.getString(4));
              objbean.setTelefono(rs.getString(5));
              objbean.setDireccion(rs.getString(6));
          
              objbean.setEstado(rs.getString(7));
              lista.add(objbean);
            }
              rs.close();
              pt.close();
              cn.close();
            } catch (Exception e) { 
         }
          return lista;
     }
    
    public int GrabarProfesor(ProfesorBean obj) {
              try {
                cn = ConexionBD.getConexionBD();
                pt = cn.prepareStatement("INSERT INTO profesor VALUES (?,?,?,?,?,?,?);");
                pt.setInt(1, obj.getIdprofesor());
                pt.setString(2, obj.getNombres());
                pt.setString(3, obj.getDni());
                pt.setString(4, obj.getCorreo());
                pt.setString(5, obj.getTelefono());
                pt.setString(6, obj.getDireccion());
           
                pt.setString(7, obj.getEstado());
                i = pt.executeUpdate();
                pt.close();
                cn.close();
              } catch (Exception e){
                i = 0;
            }
             return i;
        }
    public int ModificarProfesor(ProfesorBean obj) {
              try {
                cn = ConexionBD.getConexionBD();
                pt = cn.prepareStatement("UPDATE profesor set nombres=?, dni=?, correo=?, telefono=?, direccion=?, estado=? where idprofesor=?");
                pt.setString(1, obj.getNombres());
                pt.setString(2, obj.getDni());
                pt.setString(3, obj.getCorreo());
                pt.setString(4, obj.getTelefono());
                pt.setString(5, obj.getDireccion());

                pt.setString(6, obj.getEstado());
                pt.setInt(7, obj.getIdprofesor());
                i = pt.executeUpdate();
                pt.close();
                cn.close();
              } catch (Exception e){
                i = 0;
            }
             return i;     
    }
    
    public int GenerarCodigo() {
            int cod = 0;
              try {
                cn  =  ConexionBD.getConexionBD();
                pt  = cn.prepareStatement("SELECT MAX(idprofesor) FROM profesor ;");  
                rs=pt.executeQuery();
                rs.next();
                int c=Integer.parseInt(rs.getString(1))+1;
                String id="";
                if(c<10000000){id=""+c;}
                cod=Integer.parseInt(id);
              } catch (Exception e) {
            }
             return cod;    
          }
    
    public ProfesorBean CapturarDatos(ProfesorBean obj) {
            try {
              cn  =  ConexionBD.getConexionBD();
              pt=cn.prepareStatement("SELECT n.idprofesor,n.nombres,n.dni,n.correo,n.telefono,n.direccion,n.estado FROM profesor n WHERE n.idprofesor="+obj.getIdprofesor());  
              rs=pt.executeQuery();
              while(rs.next()){
                    objcapturar=new ProfesorBean();
                    objcapturar.setIdprofesor(rs.getInt(1));
                    objcapturar.setNombres(rs.getString(2));
                    objcapturar.setDni(rs.getString(3));
                    objcapturar.setCorreo(rs.getString(4));
                    objcapturar.setTelefono(rs.getString(5));
                    objcapturar.setDireccion(rs.getString(6));
        
                    objcapturar.setEstado(rs.getString(7));
              }
             } catch (Exception e) {
            }
             return objcapturar;  
       }
    
    public int EliminarProfesor(ProfesorBean obj) {
              int i = 0;
              try {
               cn = ConexionBD.getConexionBD();
               pt = cn.prepareStatement("DELETE FROM profesor WHERE idprofesor=?;");
               pt.setInt(1, obj.getIdprofesor());
               i = pt.executeUpdate();
               pt.close();
               cn.close();
             } catch (Exception e){
               i = 0;
            }
              return i;
         }   



}
