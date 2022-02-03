package UTIL;
import java.sql.*;

public class ConexionBD
{
    public static Connection getConexionBD()
    {
        Connection cn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/bdfachadamatricula", "root", "");
            System.out.println("Se conecto");
        } catch (Exception e)
        {
            System.out.println("No se conecto");
        }
        return cn;
    }
    
    public static void main(String[] args)
    {
        getConexionBD();
    }
}
