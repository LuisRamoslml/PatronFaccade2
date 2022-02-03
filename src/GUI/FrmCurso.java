package GUI;

import BEAN.CursoBean;
import FACHADA.Fachada;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;


public class FrmCurso extends JFrame implements ActionListener,MouseListener
{
    private JLabel lblCodigo, lblNombre;
    private JTextField txtCodigo, txtNombre;
    private JButton btnAgregar, btnModificar, btnEliminar;
    private JTable tabla;
    DefaultTableModel tablaModel;
    private JScrollPane Panel;
FACHADA.Fachada objfachada=null;
    public static int codigo;
        ArrayList<CursoBean> ListaCurso;
        CursoBean objCursoBean=null;

    
    public static void main(String[] args)
    {
        FrmCurso inst = new FrmCurso();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }
    
    public FrmCurso()
    {
        initGUI();
        ListarCurso();
    }
    
    private void initGUI()
    {
        String columnas[]={"CODIGO","NOMBRE"};
        try
        {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
 getContentPane().setBackground(new Color(127,140,141));                     lblCodigo=new JLabel();
            getContentPane().add(lblCodigo);
            lblCodigo.setText("Codigo:");
            lblCodigo.setBounds(131,40,57,14);
            
            txtCodigo=new JTextField();
            getContentPane().add(txtCodigo);
            txtCodigo.setEnabled(false);
            txtCodigo.setBounds(185,40,159,21);
            
            lblNombre=new JLabel();
            getContentPane().add(lblNombre);
            lblNombre.setText("Nombre:");
            lblNombre.setBounds(125,70,57,14);
            
            txtNombre=new JTextField();
            getContentPane().add(txtNombre);
            txtNombre.setBounds(185,70,159,21);
            
            btnAgregar=new JButton();
            getContentPane().add(btnAgregar);
            btnAgregar.setText("Agregar");
            btnAgregar.setBounds(80, 100, 110, 30);
            btnAgregar.addActionListener(this);
            
            btnModificar=new JButton();
            getContentPane().add(btnModificar);
            btnModificar.setText("Modificar");
            btnModificar.setBounds(200, 100, 120, 30);
            btnModificar.setEnabled(false);
            btnModificar.addActionListener(this);
            
            btnEliminar=new JButton();
            getContentPane().add(btnEliminar);
            btnEliminar.setText("Eliminar");
            btnEliminar.setBounds(330, 100, 120, 30);
            btnEliminar.setEnabled(false);
            btnEliminar.addActionListener(this);
            
            Panel=new JScrollPane();
            getContentPane().add(Panel);
            Panel.setBounds(20,140,500,200);
            
            tablaModel=new DefaultTableModel(null,columnas);
            tabla=new JTable();
            Panel.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(tablaModel);
            
            this.setResizable(false);
            this.setSize(570,400);
        } catch (Exception e)
        {
        }
    }
    
    private void LimpiarCampos()
    {
        txtNombre.setText(null);
        txtNombre.requestFocus();
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    private void ListarCurso()
    {
        int i = 0;
        try
        {
            objfachada=new Fachada();
            ListaCurso=objfachada.listacursos();
            codigo=objfachada.generarcodigocurso();
            if(codigo == 0)
                txtCodigo.setText("1");
            else
                txtCodigo.setText(String.valueOf(codigo));
            tablaModel.setNumRows(ListaCurso.size());
            for(CursoBean obj:ListaCurso)
            {
                tablaModel.setValueAt(obj.getIdcurso(), i, 0);
                tablaModel.setValueAt(obj.getNombre(), i, 1);
                i++;
            }
            tabla.setModel(tablaModel);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void AgregarCurso(){
        try {
            objfachada=new Fachada();
            objCursoBean = new CursoBean();
            objCursoBean.setIdcurso(Integer.parseInt(txtCodigo.getText()));
            objCursoBean.setNombre(txtNombre.getText());
           int i=objfachada.grabarcurso(objCursoBean);
           if(i==1){
               JOptionPane.showMessageDialog(null, "SE GRABO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE GRABO CORRECTAMENTE");

           }
            LimpiarCampos();
            ListarCurso();
        } catch (Exception e) {
        }
    }
    
    private void ModificarCurso(){
        try {
            objCursoBean = new CursoBean();
            objCursoBean.setIdcurso(Integer.parseInt(txtCodigo.getText()));
            objCursoBean.setNombre(txtNombre.getText());
                       int i=objfachada.modificarcurso(objCursoBean);
  if(i==1){
               JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE MODIFICO CORRECTAMENTE");

           }
            LimpiarCampos();
            ListarCurso();
        } catch (Exception e) {
        }
    }
    
    private void EliminarCurso(){
        try {
            objCursoBean = new CursoBean();
            objfachada=new Fachada();
            objCursoBean.setIdcurso(Integer.parseInt(txtCodigo.getText()));
                      int i=objfachada.eliminarcurso(objCursoBean);
  if(i==1){
               JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE ELIMINO CORRECTAMENTE");

           }
            LimpiarCampos();
            ListarCurso();
        } catch (Exception e) {
        }
    }
    
    private void Validacion(int x)
    {
        try
        {
            if(txtNombre.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese Nombre");
                txtNombre.requestFocus();
            }else
            {
                switch(x)
                {
                    case 1://Agregar
                    {
                        AgregarCurso();
                        break;
                    }
                    case 2://Modificar
                    {
                        ModificarCurso();
                        break;
                    }
                }
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void SeleccionarCurso()
    {
        try
        {
            txtCodigo.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            txtNombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnAgregar)
        {
            Validacion(1);
        }
        if(e.getSource() == btnModificar)
        {
            Validacion(2);
        }
        if(e.getSource() == btnEliminar)
        {
            EliminarCurso();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource() == tabla)
        {
            SeleccionarCurso();
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
