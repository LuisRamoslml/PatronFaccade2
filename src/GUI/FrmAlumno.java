/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BEAN.AlumnoBean;
import BEAN.MatriculaBean;
import FACHADA.Fachada;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Home
 */
public class FrmAlumno extends JFrame implements MouseListener,ActionListener{
    private JLabel lblidalumno,lblnombre,lbldni,lblcorreo,lbltelefono,lbldireccion,lblestado,lbltitulo;
    private TextField txtidalumno,txtnombre,txtdni,txtcorreo,txttelfono,txtdireccion,txtestado;
    private JComboBox cboestado;
    private  JButton btneliminar,btngrabar,btnmodificar;
    private JTable tabla;
    private JScrollPane Panel;
    DefaultTableModel tablemodel;
    
    ArrayList<AlumnoBean>lista;
    ArrayList<AlumnoBean>listaalumno;
      AlumnoBean objbean1=null;
FACHADA.Fachada objfachada=null;
    
       public  FrmAlumno(){
        GUI();
        mostrar();
    }
    public static void main(String[]args){
        FrmAlumno principal=new FrmAlumno();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
    
    public void GUI(){
         String columnas[]={"CODIGO","NOMBRE","DNI","CORREO","TELEFONO","DIRECCION","ESTADO"};
         try {
             setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
             getContentPane().setLayout(null);
 getContentPane().setBackground(new Color(127,140,141));             
             txtidalumno=new TextField();
             getContentPane().add(txtidalumno);
             txtidalumno.setBounds(200, 84, 157, 23);
             
             txtnombre=new TextField();
             getContentPane().add(txtnombre);
             txtnombre.setBounds(200, 124, 157, 23);
                   

             txtdni=new TextField();
             getContentPane().add(txtdni);
             txtdni.setBounds(200, 164, 157, 23);
             
             txtcorreo=new TextField();
             getContentPane().add(txtcorreo);
             txtcorreo.setBounds(200, 204, 157, 23);
             
             txttelfono=new TextField();
             getContentPane().add(txttelfono);
             txttelfono.setBounds(200, 244, 157, 23);
             
             txtdireccion=new TextField();
             getContentPane().add(txtdireccion);
             txtdireccion.setBounds(600, 84, 157, 23);
             
          
             
             
             cboestado=new JComboBox();
             getContentPane().add(cboestado);
             cboestado.setBounds(600,124,157,23);
             
             
                 lblidalumno=new JLabel();
             getContentPane().add(lblidalumno);
             lblidalumno.setText("CODIGO ");
             lblidalumno.setBounds(70,84,200,30);
             
             lblnombre=new JLabel();
             getContentPane().add(lblnombre);
             lblnombre.setText("NOMBRE");
             lblnombre.setBounds(70,124,200,30);
             
             lbldni=new JLabel();
             getContentPane().add(lbldni);
             lbldni.setText("DNI");
             lbldni.setBounds(70,164,200,30);
             
             lblcorreo=new JLabel();
             getContentPane().add(lblcorreo);
             lblcorreo.setText("CORREO");
             lblcorreo.setBounds(70,204,200,30);
             
             lbltelefono=new JLabel();
             getContentPane().add(lbltelefono);
             lbltelefono.setText("TELEFONO");
             lbltelefono.setBounds(70,244,200,30);
             
             lbldireccion=new JLabel();
             getContentPane().add(lbldireccion);
             lbldireccion.setText("DIRECCION");
             lbldireccion.setBounds(500,84,200,30);
       
             
             lblestado=new JLabel();
             getContentPane().add(lblestado);
             lblestado.setText("ESTADO");
             lblestado.setBounds(500,124,200,30);
             

          
             btngrabar=new JButton();
             getContentPane().add(btngrabar);
             btngrabar.setText("GRABAR");
             btngrabar.setBounds(90,300,140,23);
             btngrabar.addActionListener(this);
             btngrabar.setBackground(new Color(0,102,153));
             
                 btnmodificar=new JButton();
             getContentPane().add(btnmodificar);
             btnmodificar.setText("MODIFICAR");
             btnmodificar.setBounds(350,300,140,23);
             btnmodificar.addActionListener(this);
             btnmodificar.setBackground(new Color(0,102,153));
             btnmodificar.setEnabled(false);
             
                 btneliminar=new JButton();
             getContentPane().add(btneliminar);
             btneliminar.setText("ELIMINAR");
             btneliminar.setBounds(620,300,140,23);
             btneliminar.addActionListener(this);
             btneliminar.setBackground(new Color(0,102,153));
               btneliminar.setEnabled(false);
          
   
            
             
              Panel=new JScrollPane();
            getContentPane().add(Panel);
            Panel.setBounds(20,400,800,300);
            
            tablemodel=new DefaultTableModel(null,columnas);
            tabla=new JTable();
            Panel.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(tablemodel);
             
            this.setSize(860,800);
         } catch (Exception e) {
             e.printStackTrace();
         }
}
    
    
    public void mostrar(){
        
      objfachada=new Fachada();
              int cod=objfachada.generarcodigoalumno();
        lista=objfachada.listaalumnos();
       if(cod==0){
           cod=cod+1;
            txtidalumno.setText(String.valueOf(cod));
       }else{
            txtidalumno.setText(String.valueOf(cod));
       }
      
        txtidalumno.setEnabled(false);
        
       int i=0;
            tablemodel.setNumRows(lista.size());
            String estado="";
             for(AlumnoBean obj:lista){
                 tablemodel.setValueAt(obj.getIdalumno(), i,0);
                tablemodel.setValueAt(obj.getNombres(),i,1);
                tablemodel.setValueAt(obj.getDni(), i,2);
              tablemodel.setValueAt(obj.getCorreo(),i,3);
                tablemodel.setValueAt(obj.getTelefono(),i,4);
                 tablemodel.setValueAt(obj.getDireccion(),i,5);

              if(obj.getEstado().equals("1")){
                  estado="HABILITADO";
                    tablemodel.setValueAt(estado,i,6);
              }else{
                  estado="DESHABILITADO";
                    tablemodel.setValueAt(estado,i,6);
              }
                  i++;
            }
             
             
             cboestado.addItem("---SELECCIONAR---");
             cboestado.addItem("HABILITADO");
             cboestado.addItem("DESHABILITADO");
           
    }
             
            public void Seleccionar(){
          
        try{
         
     
      
        txtidalumno.setText(tabla.getValueAt(tabla.getSelectedRow(),0).toString());
        int cod=Integer.parseInt(txtidalumno.getText());
         objbean1=new AlumnoBean();
           objbean1.setIdalumno(cod);
           
           
  objfachada=new Fachada();
  objbean1=objfachada.cargaralumno(objbean1);
            
           txtidalumno.setText(String.valueOf(objbean1.getIdalumno()));
           cboestado.removeAllItems();
           if(objbean1.getEstado().equals("1")){
               cboestado.addItem("HABILITADO");
                 cboestado.addItem("---SELECCIONAR----");
                   cboestado.addItem("DESHABILITADO");
           }else{
              cboestado.addItem("DESHABILITADO");
                 cboestado.addItem("---SELECCIONAR----");
                   cboestado.addItem("HABILITADO"); 
           }
             txtnombre.setText(String.valueOf(objbean1.getNombres()));
               txtdni.setText(String.valueOf(objbean1.getDni()));
                 txtcorreo.setText(String.valueOf(objbean1.getCorreo()));
                   txttelfono.setText(String.valueOf(objbean1.getTelefono()));
                     txtdireccion.setText(String.valueOf(objbean1.getDireccion()));
            
          
           btngrabar.setEnabled(false);
           btnmodificar.setEnabled(true);
           btneliminar.setEnabled(true);

        }catch(Exception e){
            
        }
        
    }   
                 public void Limpiar(){
       //actualizar combobox
       cboestado.removeAllItems();
       txtnombre.setText("");
        txtdni.setText("");
         txtcorreo.setText("");
          txttelfono.setText("");
           txtdireccion.setText("");
         
       btngrabar.setEnabled(true);
       btnmodificar.setEnabled(false);
       btneliminar.setEnabled(false);
       txtnombre.requestFocus();
        
        
    }
                   public void grabaralumno(){
       
       objbean1=new AlumnoBean();
       objbean1.setIdalumno(Integer.parseInt(txtidalumno.getText()));
       objbean1.setNombres(txtnombre.getText());
       objbean1.setDni(txtdni.getText());
       objbean1.setCorreo(txtcorreo.getText());
          objbean1.setTelefono(txttelfono.getText());
        objbean1.setDireccion(txtdireccion.getText());

       if(cboestado.getSelectedItem().equals("HABILITADO")){
            objbean1.setEstado("1");
       }else{
           objbean1.setEstado("2");
       }
        
         objfachada=new Fachada();
         int i=objfachada.grabaralumno(objbean1);
            if(i==1){
               JOptionPane.showMessageDialog(null, "SE GRABO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE GRABO CORRECTAMENTE");

           }
       Limpiar();
        mostrar();
    }
                   
                    public void modificaralumno(){
       
       objbean1=new AlumnoBean();
       objbean1.setIdalumno(Integer.parseInt(txtidalumno.getText()));
       objbean1.setNombres(txtnombre.getText());
       objbean1.setDni(txtdni.getText());
       objbean1.setCorreo(txtcorreo.getText());
          objbean1.setTelefono(txttelfono.getText());
        objbean1.setDireccion(txtdireccion.getText());

       if(cboestado.getSelectedItem().equals("HABILITADO")){
            objbean1.setEstado("1");
       }else{
           objbean1.setEstado("2");
       }
        
     objfachada=new Fachada();
     int i=objfachada.modiifcaralumno(objbean1);
         if(i==1){
                JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE MODIFICO CORRECTAMENTE");

           }
       Limpiar();
        mostrar();
    }
                    public void eliminar(){
        objbean1=new AlumnoBean();
        objbean1.setIdalumno(Integer.parseInt(txtidalumno.getText()));
        objfachada=new Fachada();
        int i=objfachada.eliminaralumno(objbean1);
           if(i==1){
                JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE ELIMINO CORRECTAMENTE");

           }
        Limpiar();
        mostrar();
                
        
    }
      public void ValidacionGrabar(){
       
            if(!txtnombre.getText().equals("")){
                if(!txtdni.getText().equals("")){
                    if(!txtcorreo.getText().equals("")){
                        if(!txttelfono.getText().equals("")){
                              if(!txtdireccion.getText().equals("")){
         
                        if(cboestado.getSelectedIndex()!=0){
                            grabaralumno();
                        }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE EL ESTADO DEL ALUMNO ");
                        }
                 
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE LA DIRECCION DEL ALUMNO");
                        txtdireccion.requestFocus();

        }  }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE  EL TELEFONO DEL ALUMNO ");
                                        txttelfono.requestFocus();

                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE EL CORREO DEL ALUMNO");
                                    txtcorreo.requestFocus();

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "SELECCIONE EL DNI DEL ALUMNO");
                                txtdni.requestFocus();

                }
        
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE EL NOMBRE  DEL ALUMNO");
            txtnombre.requestFocus();
        }
   
    }
      public void ValidacionModificar(){
       
            if(!txtnombre.getText().equals("")){
                if(!txtdni.getText().equals("")){
                    if(!txtcorreo.getText().equals("")){
                        if(!txttelfono.getText().equals("")){
                              if(!txtdireccion.getText().equals("")){
             
                        if(cboestado.getSelectedIndex()!=1){
                            modificaralumno();
                        }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE EL ESTADO DEL ALUMNO ");
                        }
        
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE LA DIRECCION DEL ALUMNO");
                        txtdireccion.requestFocus();

        }  }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE  EL TELEFONO DEL ALUMNO ");
                                        txttelfono.requestFocus();

                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE EL CORREO DEL ALUMNO");
                                    txtcorreo.requestFocus();

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "SELECCIONE EL DNI DEL ALUMNO");
                                txtdni.requestFocus();

                }
        
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE EL NOMBRE  DEL ALUMNO");
            txtnombre.requestFocus();
        }
   
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btngrabar){
            ValidacionGrabar();
     }
          if(e.getSource()==btnmodificar){
            ValidacionModificar();
     }
            if(e.getSource()==btneliminar){
            eliminar();
     }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
     if(e.getSource()==tabla){
         Seleccionar();
     }
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    

}
