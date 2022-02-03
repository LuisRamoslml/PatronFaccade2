/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUBSISTEMAS;

import BEAN.HorarioBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class HorarioDAO {
     Connection cn=null;
    PreparedStatement pt=null;
    ArrayList<HorarioBean>ListaHorario;
    ArrayList<HorarioBean>ListaCurso;
    ArrayList<HorarioBean>ListaProfesor;
    public static ArrayList<HorarioBean> lista=null;
    public static ArrayList<HorarioBean> listaxp=null;
    HorarioBean objHorarioBean=null;
    public static HorarioBean obj1=null;
    ResultSet rs=null;

    public ArrayList<HorarioBean> ListarHorarios() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT h.idhorario, h.dia, h.horainicio, h.horafin, h.seccion, h.aula, h.idprofesor, p.nombres, h.idcurso, c.nombre FROM horario h INNER JOIN profesor p ON p.idprofesor = h.idprofesor INNER JOIN curso c ON c.idcurso = h.idcurso;");
            rs = pt.executeQuery();
            ListaHorario = new ArrayList<>();
            while(rs.next()){
                objHorarioBean = new HorarioBean();
                objHorarioBean.setIdhorario(rs.getInt(1));
                objHorarioBean.setDia(rs.getString(2));
                objHorarioBean.setHorainicio(rs.getString(3));
                objHorarioBean.setHorafin(rs.getString(4));
                objHorarioBean.setSeccion(rs.getString(5));
                objHorarioBean.setAula(rs.getString(6));
                objHorarioBean.setIdprofesor(rs.getInt(7));
                objHorarioBean.setNomprofesor(rs.getString(8));
                objHorarioBean.setIdcurso(rs.getInt(9));
                objHorarioBean.setNomcurso(rs.getString(10));
                ListaHorario.add(objHorarioBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaHorario;
    }

    public ArrayList<HorarioBean> CargarCursos() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT * FROM curso;");
            rs = pt.executeQuery();
            ListaCurso = new ArrayList<>();
            while(rs.next()){
                objHorarioBean = new HorarioBean();
                objHorarioBean.setIdcurso(rs.getInt(1));
                objHorarioBean.setNomcurso(rs.getString(2));
                ListaCurso.add(objHorarioBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaCurso;
    }

    public ArrayList<HorarioBean> CargarProfesor() {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT idprofesor, nombres FROM profesor;");
            rs = pt.executeQuery();
            ListaProfesor = new ArrayList<>();
            while(rs.next()){
                objHorarioBean = new HorarioBean();
                objHorarioBean.setIdprofesor(rs.getInt(1));
                objHorarioBean.setNomprofesor(rs.getString(2));
                ListaProfesor.add(objHorarioBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaProfesor;
    }

    public int AgregarHorario(HorarioBean obj) {
        int i = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("INSERT INTO horario VALUES (?,?,?,?,?,?,?,?)");
            pt.setInt(1, obj.getIdhorario());
            pt.setString(2, obj.getDia());
            pt.setString(3, obj.getHorainicio());
            pt.setString(4, obj.getHorafin());
            pt.setString(5, obj.getSeccion());
            pt.setString(6, obj.getAula());
            pt.setInt(7, obj.getIdprofesor());
            pt.setInt(8, obj.getIdcurso());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public int ModificarHorario(HorarioBean obj) {
        int i = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("UPDATE horario SET dia=?, horainicio=?, horafin=?, seccion=?, aula=?, idprofesor=?, idcurso=? WHERE idhorario=?");
            pt.setString(1, obj.getDia());
            pt.setString(2, obj.getHorainicio());
            pt.setString(3, obj.getHorafin());
            pt.setString(4, obj.getSeccion());
            pt.setString(5, obj.getAula());
            pt.setInt(6, obj.getIdprofesor());
            pt.setInt(7, obj.getIdcurso());
            pt.setInt(8, obj.getIdhorario());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }

    public int EliminarHorario(HorarioBean obj) {
        int i = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("DELETE FROM horario WHERE idhorario="+obj.getIdhorario());
            i = pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }

    public int GenerarCodigo() {
        int cod = 0;
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT MAX(idhorario) FROM horario;");
            rs = pt.executeQuery();
            rs.next();
            cod = Integer.parseInt(rs.getString(1));
            cod = cod + 1;
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return cod;
    }

    public HorarioBean CargarHorario(HorarioBean obj) {
        try {
            cn = ConexionBD.getConexionBD();
            pt = cn.prepareStatement("SELECT h.idhorario, h.dia, h.horainicio, h.horafin, h.seccion, h.aula, h.idprofesor, p.nombres, h.idcurso, c.nombre FROM horario h INNER JOIN profesor p ON p.idprofesor = h.idprofesor INNER JOIN curso c ON c.idcurso = h.idcurso WHERE h.idhorario="+obj.getIdhorario());
            rs = pt.executeQuery();
            while(rs.next()){
                obj1 = new HorarioBean();
                obj1.setIdhorario(rs.getInt(1));
                obj1.setDia(rs.getString(2));
                obj1.setHorainicio(rs.getString(3));
                obj1.setHorafin(rs.getString(4));
                obj1.setSeccion(rs.getString(5));
                obj1.setAula(rs.getString(6));
                obj1.setIdprofesor(rs.getInt(7));
                obj1.setNomprofesor(rs.getString(8));
                obj1.setIdcurso(rs.getInt(9));
                obj1.setNomcurso(rs.getString(10));
            }
        } catch (Exception e) {
        }
        return obj1;
    }

    public ArrayList<HorarioBean> MostrarHorarioAlumno(HorarioBean obj) {
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT c.nombre, p.nombres, h.aula, h.seccion, h.dia, h.horainicio, h.horafin from horario h inner join profesor p on h.idprofesor=p.idprofesor inner join curso c on h.idcurso=c.idcurso inner join detallematricula d on c.idcurso=d.idcurso inner join matricula m on d.idmatricula=m.idmatricula inner join alumno a on m.idalumno=a.idalumno where a.idalumno=?");
            pt.setInt(1, obj.getIdalumno());
            rs=pt.executeQuery();
            lista=new ArrayList<HorarioBean>();
            while(rs.next()){
                objHorarioBean=new HorarioBean();
                objHorarioBean.setNomcurso(rs.getString(1));
                objHorarioBean.setNomprofesor(rs.getString(2));
                objHorarioBean.setAula(rs.getString(3));
                objHorarioBean.setSeccion(rs.getString(4));
                objHorarioBean.setDia(rs.getString(5));
                objHorarioBean.setHorainicio(rs.getString(6));
                objHorarioBean.setHorafin(rs.getString(7));
                lista.add(objHorarioBean);
            }
                            
            cn.close();
            pt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<HorarioBean> MostrarHorarioProfesor(HorarioBean obj) {
        try {
            cn=ConexionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT h.idhorario, h.dia, h.horainicio, h.horafin, h.seccion, h.aula, h.idprofesor, p.nombres, h.idcurso, c.nombre FROM horario h INNER JOIN profesor p ON p.idprofesor = h.idprofesor INNER JOIN curso c ON c.idcurso = h.idcurso where h.idprofesor="+obj.getIdprofesor());
            rs=pt.executeQuery();
            listaxp=new ArrayList<HorarioBean>();
            while(rs.next()){
                objHorarioBean=new HorarioBean();
                objHorarioBean.setIdhorario(rs.getInt(1));
                objHorarioBean.setDia(rs.getString(2));
                objHorarioBean.setHorainicio(rs.getString(3));
                objHorarioBean.setHorafin(rs.getString(4));
                objHorarioBean.setSeccion(rs.getString(5));
                objHorarioBean.setAula(rs.getString(6));
                objHorarioBean.setIdprofesor(rs.getInt(7));
                objHorarioBean.setNomprofesor(rs.getString(8));
                objHorarioBean.setIdcurso(rs.getInt(9));
                objHorarioBean.setNomcurso(rs.getString(10));
                listaxp.add(objHorarioBean);

            }
                            
            cn.close();
            pt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaxp;
    }
}
