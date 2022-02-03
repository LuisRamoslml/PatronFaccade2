
package SUBSISTEMAS;

import UTIL.ConexionBD;
import BEAN.SecretariaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SecretariaDAO {
    Connection cn=null;
         SecretariaBean objbean=null;
         public static ArrayList<SecretariaBean> lista=null;
         PreparedStatement pt =null;
         ResultSet rs =null;
         public static int i = 0;
         public static SecretariaBean objcapturar=null;
         
         public int ValidarAcceso(SecretariaBean obj)
    {
        
        int estado=0;
        try
        {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT COUNT(*) FROM SECRETARIA WHERE usuario=? AND clave=?;");
            pt.setString(1, obj.getUsuario());
            pt.setString(2, obj.getClave());
          
            rs=pt.executeQuery();
            if(rs.next())
            {
                estado = rs.getInt(1);
            }
            rs.close();
            pt.close();
            cn.close();
        } catch (Exception e)
        {
            estado = 0;
        }
        return estado;
    }
   
}
