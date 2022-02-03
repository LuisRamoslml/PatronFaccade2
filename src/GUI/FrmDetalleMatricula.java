/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BEAN.AlumnoBean;
import BEAN.CursoBean;
import BEAN.DetalleMastriculaBean;
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
public class FrmDetalleMatricula  extends JFrame implements ActionListener,MouseListener{
    private JLabel lbltitulo,LBLMATRICULA,LBLCURSO;
    private JComboBox CBOIDMATRICULA,CBOIDCURSO;
    private  JButton btneliminar,btngrabar,btnmodificar,btnalctualizar;
    private JTable tabla;
    private JScrollPane Panel;
    DefaultTableModel tablemodel;
    
    ArrayList<DetalleMastriculaBean>lista;
    ArrayList<DetalleMastriculaBean>listamatricula;
      ArrayList<DetalleMastriculaBean>listacursos;
     DetalleMastriculaBean objbean1=null;
FACHADA.Fachada objfachada=null;
    
    
       public  FrmDetalleMatricula(){
        GUI();
        mostrar();
    }
    public static void main(String[]args){
        FrmDetalleMatricula principal=new FrmDetalleMatricula();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
    
    public void GUI(){
         String columnas[]={"MATRICULA","COD CURSO","CURSO"};
         try {
             setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
             getContentPane().setLayout(null);
 getContentPane().setBackground(new Color(127,140,141));                      
             CBOIDMATRICULA=new JComboBox();
             getContentPane().add(CBOIDMATRICULA);
           
             CBOIDMATRICULA.setBounds(240,124,157,23);
             

             
             CBOIDCURSO=new JComboBox();
             getContentPane().add(CBOIDCURSO);
            
             CBOIDCURSO.setBounds(240,164,157,23);
             
             
                LBLMATRICULA=new JLabel();
             getContentPane().add(LBLMATRICULA);
             LBLMATRICULA.setText("MATRICULA");
             LBLMATRICULA.setBounds(70,124,200,30);
             
                LBLCURSO=new JLabel();
             getContentPane().add(LBLCURSO);
             LBLCURSO.setText("CURSO");
             LBLCURSO.setBounds(70,164,200,30);
             
             

             
             btngrabar=new JButton();
             getContentPane().add(btngrabar);
             btngrabar.setText("GRABAR");
             btngrabar.setBounds(60,204,140,23);
             btngrabar.addActionListener(this);
             btngrabar.setBackground(new Color(0,102,153));
             
                 btnmodificar=new JButton();
             getContentPane().add(btnmodificar);
             btnmodificar.setText("MODIFICAR");
             btnmodificar.setBounds(270,204,140,23);
             btnmodificar.addActionListener(this);
             btnmodificar.setBackground(new Color(0,102,153));
             btnmodificar.setEnabled(false);
             
                 btneliminar=new JButton();
             getContentPane().add(btneliminar);
             btneliminar.setText("ELIMINAR");
             btneliminar.setBounds(60,244,140,23);
             btneliminar.addActionListener(this);
             btneliminar.setBackground(new Color(0,102,153));
               btneliminar.setEnabled(false);
          
           
             
              Panel=new JScrollPane();
            getContentPane().add(Panel);
            Panel.setBounds(20,300,450,200);
            
            tablemodel=new DefaultTableModel(null,columnas);
            tabla=new JTable();
            Panel.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(tablemodel);
             
            this.setSize(500,600);
         } catch (Exception e) {
             e.printStackTrace();
         }
}
    
    
    public void mostrar(){
        
     objfachada=new FACHADA.Fachada();

        lista=objfachada.listadetalematricula();
        listamatricula=objfachada.listadetalematriculaMATRICULAS();
        listacursos=objfachada.listadetalematriculaCURSOS();
  
        
       int i=0;
            tablemodel.setNumRows(lista.size());
             for(DetalleMastriculaBean obj:lista){
                 tablemodel.setValueAt(obj.getIdmatricula(), i,0);
                  tablemodel.setValueAt(obj.getIdcurso(), i,1);
                tablemodel.setValueAt(obj.getNombcurso(),i,2);
               
                i++;
            }
             CBOIDMATRICULA.addItem("----Seleccionar----");
             for(DetalleMastriculaBean obj1:listamatricula){
                 CBOIDMATRICULA.addItem(new MatriculaBean(obj1.getIdmatricula()));
             }
              CBOIDCURSO.addItem("----Seleccionar----");
              for(DetalleMastriculaBean obj1:listacursos){
                     
                 CBOIDCURSO.addItem(new CursoBean(obj1.getIdcurso(), obj1.getNombcurso()));
             }
             tabla.setModel(tablemodel);
        
    }

    public void grabarmatricula(){
       MatriculaBean objcbo1=(MatriculaBean)CBOIDMATRICULA.getSelectedItem();
       CursoBean objcbo2=(CursoBean)CBOIDCURSO.getSelectedItem();
       objbean1=new DetalleMastriculaBean();

       objbean1.setIdcurso(objcbo2.getIdcurso());
          objbean1.setIdmatricula(objcbo1.getIdmatricula());
        objfachada=new Fachada();
       int i=objfachada.grabardetallmatricula(objbean1);

  
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
         objbean1=new DetalleMastriculaBean();
     objbean1.setIdmatricula(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(),0).toString()));
       objbean1.setIdcurso(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(),1).toString()));
      // JOptionPane.showMessageDialog(null, objbean1.getIdcurso());
      objfachada=new Fachada();
        listacursos=objfachada.listadetalematriculaCURSOS();
        listamatricula=objfachada.listadetalematriculaMATRICULAS();

objbean1=objfachada.cargardetalle(objbean1);
            
         
           
           CBOIDCURSO.removeAllItems();
           CBOIDMATRICULA.removeAllItems();
CBOIDMATRICULA.addItem(new MatriculaBean(objbean1.getIdmatricula()));             
           CBOIDMATRICULA.addItem("----Seleccionar----"); 
           for(DetalleMastriculaBean obj1:listamatricula){
                            CBOIDMATRICULA.addItem(new MatriculaBean(obj1.getIdmatricula()));

           }
           CBOIDCURSO.addItem(new CursoBean(objbean1.getIdcurso(), objbean1.getNombcurso()));
           CBOIDCURSO.addItem("----Seleccionar----"); 
           for(DetalleMastriculaBean obj1:listacursos){
                     
                 CBOIDCURSO.addItem(new CursoBean(obj1.getIdcurso(), obj1.getNombcurso()));
             }
           btngrabar.setEnabled(false);
           btnmodificar.setEnabled(true);
           btneliminar.setEnabled(true);
           CBOIDMATRICULA.setEnabled(false);

        }catch(Exception e){
            
        }
        
    }
    
    public void Limpiar(){
       //actualizar combobox
     
      CBOIDCURSO.removeAllItems();
      CBOIDMATRICULA.removeAllItems();
       btngrabar.setEnabled(true);
       CBOIDMATRICULA.setEnabled(true);
       btnmodificar.setEnabled(false);
       btneliminar.setEnabled(false);
        
        
    }
    
    
    public void eliminar(){
           MatriculaBean objcbo1=(MatriculaBean)CBOIDMATRICULA.getSelectedItem();
       CursoBean objcbo2=(CursoBean)CBOIDCURSO.getSelectedItem();
       objbean1=new DetalleMastriculaBean();

       objbean1.setIdcurso(objcbo2.getIdcurso());
          objbean1.setIdmatricula(objcbo1.getIdmatricula());
     objfachada=new Fachada();
        int i=objfachada.eliminardetallematricula(objbean1);
        
  
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE ELIMINO CORRECTAMENTE");

           }
        Limpiar();
        mostrar();
                
        
    }
    
    public void modificar(){
       MatriculaBean objcbo1=(MatriculaBean)CBOIDMATRICULA.getSelectedItem();
       CursoBean objcbo2=(CursoBean)CBOIDCURSO.getSelectedItem();
       objbean1=new DetalleMastriculaBean();

       objbean1.setIdcurso(objcbo2.getIdcurso());
          objbean1.setIdmatricula(objcbo1.getIdmatricula());
        objfachada=new Fachada();
        int i=objfachada.modificardetallematricula(objbean1);
        
  
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE MODIFICO CORRECTAMENTE");

           }
       Limpiar();
        mostrar();
    }
    
    public void ValidacionGrabar(){
       
            if(CBOIDCURSO.getSelectedIndex()!=0){
                if(CBOIDMATRICULA.getSelectedIndex()!=0){
                 
                            grabarmatricula();
                        }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE LA MATRICULA");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE EL CURSO");
                    }
               
   
    }
    public void ValidacionModificar(){
       
            if(CBOIDCURSO.getSelectedIndex()!=1){
                if(CBOIDMATRICULA.getSelectedIndex()!=1){
                 
                            modificar();
                         }else{
                            JOptionPane.showMessageDialog(null, "SELECCIONE LA MATRICULA");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE EL CURSO");
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
