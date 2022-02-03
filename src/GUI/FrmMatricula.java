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
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Home
 */
public class FrmMatricula  extends JFrame implements ActionListener,MouseListener{
    private JLabel lbltitulo,lblid,lblseccion,lblgrado,lblalumno;
    private TextField txtid;
    private JComboBox cboseccion,cboidgrado,cboidalum;
    private  JButton btneliminar,btngrabar,btnmodificar,btnalctualizar;
    private JTable tabla;
    private JScrollPane Panel;
    DefaultTableModel tablemodel;
    
    ArrayList<MatriculaBean>lista;
    ArrayList<MatriculaBean>listaadmin;
      ArrayList<MatriculaBean>listaalumnos;
       MatriculaBean objbean1=null;
FACHADA.Fachada objfachada=null;
    
    
       public  FrmMatricula(){
        GUI();
        mostrar();
    }
    public static void main(String[]args){
        FrmMatricula principal=new FrmMatricula();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
    
    public void GUI(){
         String columnas[]={"NUMERO","SECCION","GRADO","ALUMNO"};
         try {
             setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
             getContentPane().setLayout(null);
 getContentPane().setBackground(new Color(127,140,141));         
 txtid=new TextField();
             getContentPane().add(txtid);
             txtid.setBounds(240, 84, 157, 23);
             
             
                 lblid=new JLabel();
             getContentPane().add(lblid);
             lblid.setText("CODIGO MATRICULA");
             lblid.setBounds(70,84,200,30);
             
             lblseccion=new JLabel();
             getContentPane().add(lblseccion);
             lblseccion.setText("SECCION");
             lblseccion.setBounds(70,124,200,30);
             
             lblgrado=new JLabel();
             getContentPane().add(lblgrado);
             lblgrado.setText("GRADO");
             lblgrado.setBounds(70,164,200,30);
             

             
             lblalumno=new JLabel();
             getContentPane().add(lblalumno);
             lblalumno.setText("ALUMNO");
             lblalumno.setBounds(70,204,200,30);
             
             
             cboseccion=new JComboBox();
             getContentPane().add(cboseccion);
           
             cboseccion.setBounds(240,124,157,23);
             

             
             cboidgrado=new JComboBox();
             getContentPane().add(cboidgrado);
            
             cboidgrado.setBounds(240,164,157,23);
             
             
  
             
             cboidalum=new JComboBox();
             getContentPane().add(cboidalum);
             cboidalum.setBounds(240,204,157,23);
             
             

             
             btngrabar=new JButton();
             getContentPane().add(btngrabar);
             btngrabar.setText("GRABAR");
             btngrabar.setBounds(60,364,140,23);
             btngrabar.addActionListener(this);
             btngrabar.setBackground(new Color(0,102,153));
             
                 btnmodificar=new JButton();
             getContentPane().add(btnmodificar);
             btnmodificar.setText("MODIFICAR");
             btnmodificar.setBounds(270,364,140,23);
             btnmodificar.addActionListener(this);
             btnmodificar.setBackground(new Color(0,102,153));
             btnmodificar.setEnabled(false);
             
                 btneliminar=new JButton();
             getContentPane().add(btneliminar);
             btneliminar.setText("ELIMINAR");
             btneliminar.setBounds(60,414,140,23);
             btneliminar.addActionListener(this);
             btneliminar.setBackground(new Color(0,102,153));
               btneliminar.setEnabled(false);
          
             
         
            
             
              Panel=new JScrollPane();
            getContentPane().add(Panel);
            Panel.setBounds(20,450,450,300);
            
            tablemodel=new DefaultTableModel(null,columnas);
            tabla=new JTable();
            Panel.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(tablemodel);
             
            this.setSize(500,800);
         } catch (Exception e) {
             e.printStackTrace();
         }
}

    public void mostrar(){
        
       objfachada=new Fachada();
       int cod=objfachada.generarcodigomatricula();
       
        lista=objfachada.listamatricula();
        listaalumnos=objfachada.listamatriculaalumno();
       if(cod==0){
           cod=1;
            txtid.setText(String.valueOf(cod));
       }else{
            txtid.setText(String.valueOf(cod));
       }
      
        txtid.setEnabled(false);
        
       int i=0;
            tablemodel.setNumRows(lista.size());
             for(MatriculaBean obj:lista){
                 tablemodel.setValueAt(obj.getIdmatricula(), i,0);
                tablemodel.setValueAt(obj.getSeccion(),i,1);
                tablemodel.setValueAt(obj.getGrado(), i,2);
                tablemodel.setValueAt(obj.getNombrealumno(),i,3);
                i++;
            }
             
               cboseccion.addItem("----Seleccionar----");
             cboseccion.addItem("A");
             cboseccion.addItem("B");
             cboseccion.addItem("C");
             cboseccion.addItem("D");
             
               cboidgrado.addItem("----Seleccionar----");
             cboidgrado.addItem("1 primaria");
             cboidgrado.addItem("2 primaria");
             cboidgrado.addItem("3 primaria");
             cboidgrado.addItem("4 primaria");
              cboidgrado.addItem("5 primaria");
             cboidgrado.addItem("6 primaria");
             cboidgrado.addItem("1 secundaria");
             cboidgrado.addItem("2 secundaria");
              cboidgrado.addItem("3 secundaria");
             cboidgrado.addItem("4 secundaria");
             cboidgrado.addItem("5 secundaria");
             
           
              cboidalum.addItem("----Seleccionar----");
              for(MatriculaBean obj1:listaalumnos){
                     
                 cboidalum.addItem(new AlumnoBean(obj1.getIdalumno(), obj1.getNombrealumno()));
             }
             tabla.setModel(tablemodel);
        
    }

    public void grabarmatricula(){
       AlumnoBean objcbo2=(AlumnoBean)cboidalum.getSelectedItem();
       objbean1=new MatriculaBean();
       objbean1.setIdmatricula(Integer.parseInt(txtid.getText()));
       objbean1.setGrado(String.valueOf(cboidgrado.getSelectedItem()));
       objbean1.setSeccion(String.valueOf(cboseccion.getSelectedItem()));
       objbean1.setIdalumno(objcbo2.getIdalumno());
        
        objfachada=new Fachada();
        int i=objfachada.grabarmatricula(objbean1);
        
  
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE GRABO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE GRABO CORRECTAMENTE");

           }
       Limpiar();
        mostrar();
    }
    
    
    public void Seleccionar(){
          
        try{
         
     objfachada=new Fachada();
        listaalumnos=objfachada.listamatriculaalumno();
        txtid.setText(tabla.getValueAt(tabla.getSelectedRow(),0).toString());
        int cod=Integer.parseInt(txtid.getText());
         objbean1=new MatriculaBean();
           objbean1.setIdmatricula(cod);
           
           objbean1=objfachada.cargarmatricula(objbean1);
           
            
           txtid.setText(String.valueOf(objbean1.getIdmatricula()));
           cboidgrado.removeAllItems();
           cboseccion.removeAllItems();
           
           
          
           cboseccion.addItem(objbean1.getSeccion());
           cboseccion.addItem("----Seleccionar----");
             cboseccion.addItem("A");
             cboseccion.addItem("B");
             cboseccion.addItem("C");
             cboseccion.addItem("D");
             
              cboidgrado.addItem(objbean1.getGrado());
               cboidgrado.addItem("----Seleccionar----");
             cboidgrado.addItem("1 primaria");
             cboidgrado.addItem("2 primaria");
             cboidgrado.addItem("3 primaria");
             cboidgrado.addItem("4 primaria");
              cboidgrado.addItem("5 primaria");
             cboidgrado.addItem("6 primaria");
             cboidgrado.addItem("1 secundaria");
             cboidgrado.addItem("2 secundaria");
              cboidgrado.addItem("3 secundaria");
             cboidgrado.addItem("4 secundaria");
             cboidgrado.addItem("5 secundaria");
           
           cboidalum.removeAllItems();
         
           
           cboidalum.addItem(new AlumnoBean(objbean1.getIdalumno(), objbean1.getNombrealumno()));
           cboidalum.addItem("----Seleccionar----"); 
           for(MatriculaBean obj1:listaalumnos){
                     
                 cboidalum.addItem(new AlumnoBean(obj1.getIdalumno(), obj1.getNombrealumno()));
             }
           btngrabar.setEnabled(false);
           btnmodificar.setEnabled(true);
           btneliminar.setEnabled(true);

        }catch(Exception e){
            
        }
        
    }
    
    public void Limpiar(){
       //actualizar combobox
       cboidalum.removeAllItems();
      cboidgrado.removeAllItems();
      cboseccion.removeAllItems();
       btngrabar.setEnabled(true);
       btnmodificar.setEnabled(false);
       btneliminar.setEnabled(false);
        
        
    }
    
    
    public void eliminar(){
        objbean1=new MatriculaBean();
        objbean1.setIdmatricula(Integer.parseInt(txtid.getText()));
         objfachada=new Fachada();
        int i=objfachada.eliminarmatricula(objbean1);
        
  
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE ELIMINO CORRECTAMENTE");

              }
        Limpiar();
        mostrar();
                
        
    }
    
    public void modificar(){
       AlumnoBean objcbo2=(AlumnoBean)cboidalum.getSelectedItem();
       objbean1=new MatriculaBean();
       objbean1.setIdmatricula(Integer.parseInt(txtid.getText()));
       objbean1.setGrado(String.valueOf(cboidgrado.getSelectedItem()));
       objbean1.setSeccion(String.valueOf(cboseccion.getSelectedItem()));
       objbean1.setIdalumno(objcbo2.getIdalumno());
        
          objfachada=new Fachada();
        int i=objfachada.modificarmatricula(objbean1);
        
  
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE MODIFICO CORRECTAMENTE");

           }
       Limpiar();
        mostrar();
    }
    
    public void ValidacionGrabar(){
       
            if(cboseccion.getSelectedIndex()!=0){
                if(cboidgrado.getSelectedIndex()!=0){
                
                        if(cboidalum.getSelectedIndex()!=0){
                            grabarmatricula();
                        }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE AL ALUMNO ");
                        }
               
                }else{
                    JOptionPane.showMessageDialog(null, "SELECCIONE EL GRADO DEL ALUMNO");
                }
        
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE LA SECCION DEL ALUMNO");
        }
   
    }
    public void ValidacionModificar(){
       
            if(cboseccion.getSelectedIndex()!=1){
                if(cboidgrado.getSelectedIndex()!=1){
                        if(cboidalum.getSelectedIndex()!=1){
                            modificar();
                        }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE AL ALUMNO ");
                        }
                
                }else{
                    JOptionPane.showMessageDialog(null, "SELECCIONE EL GRADO DEL ALUMNO");
                }
        
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE LA SECCION DEL ALUMNO");
        }
   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==btngrabar){
ValidacionGrabar();
         }
           if(e.getSource()==btneliminar){
               eliminar();
         }
              if(e.getSource()==btnmodificar){
               ValidacionModificar();
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
