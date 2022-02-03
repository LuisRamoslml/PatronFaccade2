package GUI;

import BEAN.CursoBean;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import BEAN.HorarioBean;
import BEAN.ProfesorBean;
import FACHADA.Fachada;

import java.util.ArrayList;

public class FrmHorario extends JFrame implements ActionListener,MouseListener
{
    private JLabel lblCodigo, lblDia, lblHoraInicio, lblHoraFin, lblSeccion, lblAula, lblProfesor, lblCurso;
    private JTextField txtCodigo, txtHoraInicio, txtHoraFin;
    private JComboBox cboDia, cboSeccion, cboAula, cboProfesor, cboCurso;
    private JButton btnAgregar, btnModificar, btnEliminar;
    private JTable tabla;
    DefaultTableModel tablaModel;
    private JScrollPane Panel;
   ArrayList<HorarioBean> ListaHorario;
   int codigo;
FACHADA.Fachada objfachada=null;
    ArrayList<HorarioBean> ListaCurso;
    ArrayList<HorarioBean> ListaProfesor;
    HorarioBean objHorarioBean;

    public static void main(String[] args)
    {
        FrmHorario inst = new FrmHorario();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }
    
    public FrmHorario()
    {
        initGUI();
        ListarHorario();
    }
    
    private void initGUI()
    {
        String columnas[] = {"CODIGO","DIA","HORAINICIO","HORAFIN","SECCION","AULA","PROFESOR","CURSO"};
        try
        {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
 getContentPane().setBackground(new Color(127,140,141));         
 lblCodigo = new JLabel();
            getContentPane().add(lblCodigo);
            lblCodigo.setText("Codigo:");
            lblCodigo.setBounds(191,40,57,14);
            
            txtCodigo = new JTextField();
            getContentPane().add(txtCodigo);
            txtCodigo.enable(false);
            txtCodigo.setBounds(245,40,159,21);
            
            lblDia = new JLabel();
            getContentPane().add(lblDia);
            lblDia.setText("Dia:");
            lblDia.setBounds(212,70,57,14);
            
            cboDia = new JComboBox();
            getContentPane().add(cboDia);
            cboDia.setBounds(245,70,159,21);
            
            lblHoraInicio = new JLabel();
            getContentPane().add(lblHoraInicio);
            lblHoraInicio.setText("Hora Inicio:");
            lblHoraInicio.setBounds(170, 100, 80, 14);
            
            txtHoraInicio = new JTextField();
            getContentPane().add(txtHoraInicio);
            txtHoraInicio.setBounds(245,100,159,21);
            
            lblHoraFin = new JLabel();
            getContentPane().add(lblHoraFin);
            lblHoraFin.setText("Hora Fin:");
            lblHoraFin.setBounds(184, 130, 80, 14);
            
            txtHoraFin = new JTextField();
            getContentPane().add(txtHoraFin);
            txtHoraFin.setBounds(245,130,159,21);
            
            lblSeccion = new JLabel();
            getContentPane().add(lblSeccion);
            lblSeccion.setText("Seccion:");
            lblSeccion.setBounds(184, 160, 80, 14);
            
            cboSeccion = new JComboBox();
            getContentPane().add(cboSeccion);
            cboSeccion.setBounds(245,160,159,21);
            
            lblAula = new JLabel();
            getContentPane().add(lblAula);
            lblAula.setText("Aula:");
            lblAula.setBounds(205, 190, 80, 14);
            
            cboAula = new JComboBox();
            getContentPane().add(cboAula);
            cboAula.setBounds(245,190,159,21);
            
            lblProfesor = new JLabel();
            getContentPane().add(lblProfesor);
            lblProfesor.setText("Profesor:");
            lblProfesor.setBounds(180,220,57,14);
            
            cboProfesor = new JComboBox();
            getContentPane().add(cboProfesor);
            cboProfesor.setBounds(245,220,159,21);
            
            lblCurso=new JLabel();
            getContentPane().add(lblCurso);
            lblCurso.setText("Curso:");
            lblCurso.setBounds(195,250,57,14);
            
            cboCurso = new JComboBox();
            getContentPane().add(cboCurso);
            cboCurso.setBounds(245,250,159,21);
            
            btnAgregar=new JButton();
            getContentPane().add(btnAgregar);
            btnAgregar.setText("Agregar");
            btnAgregar.setBounds(140, 285, 110, 30);
            btnAgregar.addActionListener(this);
            
            btnModificar=new JButton();
            getContentPane().add(btnModificar);
            btnModificar.setText("Modificar");
            btnModificar.setBounds(260, 285, 120, 30);
            btnModificar.setEnabled(false);
            btnModificar.addActionListener(this);
            
            btnEliminar=new JButton();
            getContentPane().add(btnEliminar);
            btnEliminar.setText("Eliminar");
            btnEliminar.setBounds(390, 285, 120, 30);
            btnEliminar.setEnabled(false);
            btnEliminar.addActionListener(this);
            
            Panel = new JScrollPane();
            getContentPane().add(Panel);
            Panel.setBounds(20,330,645,200);
            
            tablaModel = new DefaultTableModel(null,columnas);
            tabla = new JTable();
            Panel.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(tablaModel);
            
            this.setSize(700,600);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void CargarComboBox(){
        try {
                        objfachada=new Fachada();

            //Cargar ComboBox Dia
            cboDia.addItem("----- SELECCIONE -----");
            cboDia.addItem("LUNES");
            cboDia.addItem("MARTES");
            cboDia.addItem("MIERCOLES");
            cboDia.addItem("JUEVES");
            cboDia.addItem("VIERNES");
            //Cargar ComboBox Seccion
            cboSeccion.addItem("----- SELECCIONE -----");
            cboSeccion.addItem("A");
            cboSeccion.addItem("B");
            cboSeccion.addItem("C");
            cboSeccion.addItem("D");
            //Cargar ComboBox Aula
            cboAula.addItem("---- SELECCIONE ----");
            cboAula.addItem("A-101");
            cboAula.addItem("A-102");
            cboAula.addItem("A-103");
            cboAula.addItem("A-104");
            //Cargar ComboBox Profesor
            ListaProfesor=objfachada.listahorarioprofesor();
            cboProfesor.addItem("---- SELECCIONE ----");
            for(HorarioBean obj:ListaProfesor){
                cboProfesor.addItem(new ProfesorBean(obj.getIdprofesor(), obj.getNomprofesor()));
            }
            //Cargar ComboBox Curso
            
            ListaCurso=objfachada.listahorariocursos();
            cboCurso.addItem("----- SELECCIONE -----");
            for(HorarioBean obj:ListaCurso){
                cboCurso.addItem(new CursoBean(obj.getIdcurso(), obj.getNomcurso()));
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void ListarHorario(){
        int i = 0;
        try {
           objfachada=new Fachada();
           codigo=objfachada.generarcodigohorario();
           ListaHorario=objfachada.listahorario();
            if(codigo == 0)
                txtCodigo.setText("1");
            else
                txtCodigo.setText(String.valueOf(codigo));
            tablaModel.setNumRows(ListaHorario.size());
            for(HorarioBean obj:ListaHorario){
                tablaModel.setValueAt(obj.getIdhorario(), i, 0);
                tablaModel.setValueAt(obj.getDia(), i, 1);
                tablaModel.setValueAt(obj.getHorainicio(), i, 2);
                tablaModel.setValueAt(obj.getHorafin(), i, 3);
                tablaModel.setValueAt(obj.getSeccion(), i, 4);
                tablaModel.setValueAt(obj.getAula(), i, 5);
                tablaModel.setValueAt(obj.getNomprofesor(), i, 6);
                tablaModel.setValueAt(obj.getNomcurso(), i, 7);
                i++;
            }
            CargarComboBox();
            tabla.setModel(tablaModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void LimpiarCampos(){
        txtHoraInicio.setText(null);
        txtHoraFin.setText(null);
        //Limpiar todo los combos
        cboDia.removeAllItems();
        cboDia.requestFocus();
        cboSeccion.removeAllItems();
        cboAula.removeAllItems();
        cboProfesor.removeAllItems();
        cboCurso.removeAllItems();
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    private void AgregarHorario(){
        try {
            ProfesorBean objcbo1 = (ProfesorBean)cboProfesor.getSelectedItem();
            CursoBean objcbo2 = (CursoBean)cboCurso.getSelectedItem();
            objHorarioBean = new HorarioBean();
            objHorarioBean.setIdhorario(Integer.parseInt(txtCodigo.getText()));
            objHorarioBean.setDia(cboDia.getSelectedItem().toString());
            objHorarioBean.setHorainicio(txtHoraInicio.getText());
            objHorarioBean.setHorafin(txtHoraFin.getText());
            objHorarioBean.setSeccion(cboSeccion.getSelectedItem().toString());
            objHorarioBean.setAula(cboAula.getSelectedItem().toString());
            objHorarioBean.setIdprofesor(objcbo1.getIdprofesor());
            objHorarioBean.setIdcurso(objcbo2.getIdcurso());
            
            objfachada=new Fachada();
           int i=objfachada.grabarhorario(objHorarioBean);
           
                if(i==1){
               JOptionPane.showMessageDialog(null, "SE GRABO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE GRABO CORRECTAMENTE");

           }
           
            LimpiarCampos();
            ListarHorario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void ModificarHorario(){
        try {
            ProfesorBean objcbo1 = (ProfesorBean)cboProfesor.getSelectedItem();
            CursoBean objcbo2 = (CursoBean)cboCurso.getSelectedItem();
            objHorarioBean = new HorarioBean();
            objHorarioBean.setIdhorario(Integer.parseInt(txtCodigo.getText()));
            objHorarioBean.setDia(cboDia.getSelectedItem().toString());
            objHorarioBean.setHorainicio(txtHoraInicio.getText());
            objHorarioBean.setHorafin(txtHoraFin.getText());
            objHorarioBean.setSeccion(cboSeccion.getSelectedItem().toString());
            objHorarioBean.setAula(cboAula.getSelectedItem().toString());
            objHorarioBean.setIdprofesor(objcbo1.getIdprofesor());
            objHorarioBean.setIdcurso(objcbo2.getIdcurso());
           objfachada=new Fachada();
           int i=objfachada.modificarhorario(objHorarioBean);
           
                if(i==1){
               JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE MODIFICO CORRECTAMENTE");

           }
            LimpiarCampos();
            ListarHorario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void Validacion(int x){
        try {
            if(cboDia.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Seleccione Dia");
                cboDia.requestFocus();
            }else if(txtHoraInicio.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Escriba Hora Inicio");
                txtHoraInicio.requestFocus();
            }else if(txtHoraFin.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Escriba Hora Fin");
                txtHoraFin.requestFocus();
            }else if(cboSeccion.getSelectedItem().equals("----- SELECCIONE -----")){
                JOptionPane.showMessageDialog(null, "Seleccione Seccion");
                cboSeccion.requestFocus();
            }else if(cboAula.getSelectedItem().equals("----- SELECCIONE -----")){
                JOptionPane.showMessageDialog(null, "Seleccione Aula");
                cboAula.requestFocus();
            }else if(cboProfesor.getSelectedItem().equals("----- SELECCIONE -----")){
                JOptionPane.showMessageDialog(null, "Seleccione Profesor");
                cboProfesor.requestFocus();
            }else if(cboCurso.getSelectedItem().equals("----- SELECCIONE -----")){
                JOptionPane.showMessageDialog(null, "Seleccione Curso");
                cboCurso.requestFocus();
            }else{
                switch(x){
                    case 1:{
                        AgregarHorario();
                        break;
                    }
                    case 2:{
                        ModificarHorario();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void EliminarHorario(){
        try {
            objHorarioBean = new HorarioBean();
            objHorarioBean.setIdhorario(Integer.parseInt(txtCodigo.getText()));
             objfachada=new Fachada();
           int i=objfachada.eliminarhorraio(objHorarioBean);
           
                if(i==1){
               JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE ELIMINO CORRECTAMENTE");

           }
            LimpiarCampos();
            ListarHorario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void SeleccionarHorario(){
        try {
            txtCodigo.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            int cod = Integer.parseInt(txtCodigo.getText());
            objHorarioBean = new HorarioBean();
            objHorarioBean.setIdhorario(cod);
            objfachada=new  Fachada();
            objHorarioBean=objfachada.cargarhorario(objHorarioBean);
            cboDia.removeAllItems();
            cboSeccion.removeAllItems();
            cboAula.removeAllItems();
            cboProfesor.removeAllItems();
            cboCurso.removeAllItems();
            //codigo
            txtCodigo.setText(String.valueOf(objHorarioBean.getIdhorario()));
            //Combo Dia
            cboDia.addItem("----- SELECCIONE -----");
            cboDia.addItem("LUNES");
            cboDia.addItem("MARTES");
            cboDia.addItem("MIERCOLES");
            cboDia.addItem("JUEVES");
            cboDia.addItem("VIERNES");
            cboDia.setSelectedItem(objHorarioBean.getDia());
            //Hora Inicio
            txtHoraInicio.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            //Hora Fin
            txtHoraFin.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            //Combo Seccion
            cboSeccion.addItem("----- SELECCIONE -----");
            cboSeccion.addItem("A");
            cboSeccion.addItem("B");
            cboSeccion.addItem("C");
            cboSeccion.addItem("D");
            cboSeccion.setSelectedItem(objHorarioBean.getSeccion());
            //Combo Aula
            cboAula.addItem("---- SELECCIONE ----");
            cboAula.addItem("A-101");
            cboAula.addItem("A-102");
            cboAula.addItem("A-103");
            cboAula.addItem("A-104");
            cboAula.setSelectedItem(objHorarioBean.getAula());
            //Combo Profesor
            cboProfesor.addItem(new ProfesorBean(objHorarioBean.getIdprofesor(), objHorarioBean.getNomprofesor()));
            cboProfesor.addItem("---- SELECCIONE ----");
            for(HorarioBean obj:ListaProfesor){
                cboProfesor.addItem(new ProfesorBean(obj.getIdprofesor(), obj.getNomprofesor()));
            }
            //Combo Curso
            cboCurso.addItem(new CursoBean(objHorarioBean.getIdcurso(), objHorarioBean.getNomcurso()));
            cboCurso.addItem("----- SELECCIONE -----");
            for(HorarioBean obj:ListaCurso){
                cboCurso.addItem(new CursoBean(obj.getIdcurso(), obj.getNomcurso()));
            }
            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnAgregar){
            Validacion(1);
        }
        if(e.getSource() == btnModificar){
            Validacion(2);
        }
        if(e.getSource() == btnEliminar){
            EliminarHorario();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource() == tabla){
            SeleccionarHorario();
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
    
}
