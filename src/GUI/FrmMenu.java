package GUI;

import javax.swing.*;
import BEAN.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class FrmMenu extends JFrame implements ActionListener
{
    private JMenuBar mbPrincipal;
    public static JMenu mSistemaMenu;;
    public static JMenuItem miUsuarios;
    private JMenu mMantenimiento;
    private JMenuItem miProfesor;
    private JMenuItem miAlumnos;
    private JMenuItem miMatricula;
    private JMenuItem miCursos;
    private JMenuItem miDetalleMatricula;
    private JMenuItem miHorario;
    private JMenu mAjustes;
    private JMenuItem miSalir;
    public static JLabel lblCod;
    public static JLabel lblClave;

    

    
    public static void main(String[] args)
    {
        FrmMenu inst = new FrmMenu();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }
    
    public FrmMenu()
    {

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 400);
        initGUI();
    
    }

    
    private void initGUI()
    {
        try
        {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);
            getContentPane().setBackground(new Color(22,160,133));
            
            mbPrincipal=new JMenuBar();
            setJMenuBar(mbPrincipal);
            mbPrincipal.setBackground(new Color(240,240,240));
            
            mSistemaMenu=new JMenu();
            mbPrincipal.add(mSistemaMenu);
            
            miUsuarios=new JMenuItem();
            miUsuarios.addActionListener(this);
            mSistemaMenu.add(miUsuarios);
            
           
            
            mMantenimiento=new JMenu("Mantenimientos");
            mbPrincipal.add(mMantenimiento);
            
            
            miProfesor=new JMenuItem("Profesores");
            miProfesor.addActionListener(this);
            mMantenimiento.add(miProfesor);
            
            miAlumnos=new JMenuItem("Alumnos");
            miAlumnos.addActionListener(this);
            mMantenimiento.add(miAlumnos);
            
            miMatricula=new JMenuItem("Matricula");
            miMatricula.addActionListener(this);
            mMantenimiento.add(miMatricula);
            
            miCursos=new JMenuItem("Cursos");
            miCursos.addActionListener(this);
            mMantenimiento.add(miCursos);
            
            miDetalleMatricula=new JMenuItem("Detalle Matricula");
            miDetalleMatricula.addActionListener(this);
            mMantenimiento.add(miDetalleMatricula);
            
         
            
            miHorario=new JMenuItem("Horario");
            miHorario.addActionListener(this);
            mMantenimiento.add(miHorario);
            

                mAjustes=new JMenu("Otros");
            mbPrincipal.add(mAjustes);
            
            miSalir=new JMenuItem("Cerrar Sesion");
            miSalir.addActionListener(this);
            mAjustes.add(miSalir);
            
            lblCod=new JLabel();
            getContentPane().add(lblCod);
            lblCod.setVisible(false);
            
            lblClave=new JLabel();
            getContentPane().add(lblClave);
            lblClave.setVisible(false);
            
            this.setResizable(false);
            //this.setSize(WIDTH, HEIGHT);
            this.setTitle("Menu Principal");
            this.setSize(1200,720);
        } catch (Exception e)
        {
        }
    }
    
   
    
    private void CerrarSesion()
    {
this.dispose();
        }
    

    
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == miProfesor){
            FrmProfesor Profesor =new FrmProfesor();
            Profesor.setLocationRelativeTo(null);
            Profesor.setVisible(true);
        }
        if(e.getSource() == miAlumnos){
            FrmAlumno Alumno =new FrmAlumno();
            Alumno.setLocationRelativeTo(null);
            Alumno.setVisible(true);
        }
        if(e.getSource() == miMatricula){
            FrmMatricula Matricula = new FrmMatricula();
            Matricula.setLocationRelativeTo(null);
            Matricula.setVisible(true);
        }
        if(e.getSource() == miCursos){
            FrmCurso Curso =new  FrmCurso();
            Curso.setLocationRelativeTo(null);
            Curso.setVisible(true);
        }
        if(e.getSource() == miDetalleMatricula){
            FrmDetalleMatricula DetalleMatricula =new  FrmDetalleMatricula();
            DetalleMatricula.setLocationRelativeTo(null);
            DetalleMatricula.setVisible(true);
        }

        if(e.getSource() == miHorario){
            FrmHorario Horario = new FrmHorario();
            Horario.setLocationRelativeTo(null);
            Horario.setVisible(true);
        }
        if(e.getSource() == miSalir){
           CerrarSesion();
        }
    }
}

