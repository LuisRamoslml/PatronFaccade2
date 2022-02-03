package GUI;

import BEAN.ProfesorBean;
import FACHADA.Fachada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;




public class FrmProfesor extends JFrame implements ActionListener,MouseListener{
    private JLabel lblcodprofesor,lblnombres,lbldni,lblcorreo,lbltelefono,lbldireccion,lblresultado,lblestado;
    JTextField txtcodprofesor,txtnombres,txtdni,txtcorreo,txttelefono,txtdireccion;
    JComboBox cboestado;
    private JButton btneliminar,btngrabar,btnmodificar;
    private JTable tabla;
    private JScrollPane Panel;
    DefaultTableModel tablemodel;
    ArrayList<ProfesorBean>lista;
    ArrayList<ProfesorBean>listaestado;
 FACHADA.Fachada objfachada=null;
   ProfesorBean objcargar = null;
   ProfesorBean objeliminar = null;
     ProfesorBean objprofesorBean = null;
     int cod;
    int i;
    
    public  FrmProfesor(){
        GUI();
        Mostrar();
    }
    public static void main(String[]args){
        FrmProfesor principal=new FrmProfesor();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
    public void GUI(){
    String columnas[]={"NUMERO","NOMBRE","DNI","CORREO","TELEFONO","DIRECCION","ESTADO"};
         try {
             setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
             getContentPane().setLayout(null);
 getContentPane().setBackground(new Color(127,140,141));         
 lblcodprofesor=new JLabel();
             getContentPane().add(lblcodprofesor);
             lblcodprofesor.setText("CODIGO PROFESOR");
             lblcodprofesor.setBounds(100, 84, 157, 23);
             
             txtcodprofesor=new JTextField();
             getContentPane().add(txtcodprofesor);
             txtcodprofesor.setBounds(300, 84, 157, 23);
             
             lblnombres=new JLabel();
             getContentPane().add(lblnombres);
             lblnombres.setText("INGRESE EL NOMBRE");
             lblnombres.setBounds(100, 124, 157, 23);
             
             txtnombres=new JTextField();
             getContentPane().add(txtnombres);
             txtnombres.setBounds(300, 124, 157, 23);
             
             lbldni=new JLabel();
             getContentPane().add(lbldni);
             lbldni.setText("INGRESE EL DNI");
             lbldni.setBounds(100, 164, 157, 23);
             
             txtdni=new JTextField();
             getContentPane().add(txtdni);
             txtdni.setBounds(300, 164, 157, 23);
             
             lblcorreo=new JLabel();
             getContentPane().add(lblcorreo);
             lblcorreo.setText("INGRESE EL CORREO");
             lblcorreo.setBounds(100, 204, 157, 23);
             
             txtcorreo=new JTextField();
             getContentPane().add(txtcorreo);
             txtcorreo.setBounds(300, 204, 157, 23);
             
             lbltelefono=new JLabel();
             getContentPane().add(lbltelefono);
             lbltelefono.setText("INGRESE EL TELEFONO");
             lbltelefono.setBounds(100, 244, 157, 23);
             
             txttelefono=new JTextField();
             getContentPane().add(txttelefono);
             txttelefono.setBounds(300, 244, 157, 23);
             
             lbldireccion=new JLabel();
             getContentPane().add(lbldireccion);
             lbldireccion.setText("INGRESE LA DIRECCION");
             lbldireccion.setBounds(100, 284, 157, 23);
             
             txtdireccion=new JTextField();
             getContentPane().add(txtdireccion);
             txtdireccion.setBounds(300, 284, 157, 23);
        
             
             lblestado=new JLabel();
             getContentPane().add(lblestado);
             lblestado.setText("SELECCIO EL ESTADO");
             lblestado.setBounds(100, 324, 157, 23);
             
             cboestado=new JComboBox();
             
             getContentPane().add(cboestado);
             cboestado.setBounds(300, 324, 157, 23);
             
             btngrabar=new JButton();
             getContentPane().add(btngrabar);
             btngrabar.setText("GRABAR");
             btngrabar.setBounds(85,440,140,23);
             btngrabar.addActionListener(this);
             btngrabar.setBackground(new Color(0,102,153));
             
             btnmodificar=new JButton();
             getContentPane().add(btnmodificar);
             btnmodificar.setText("MODIFICAR");
             btnmodificar.setBounds(235,440,140,23);
             btnmodificar.addActionListener(this);
             btnmodificar.setEnabled(false);
             btnmodificar.setBackground(new Color(0,102,153));
             
             btneliminar=new JButton();
             getContentPane().add(btneliminar);
             btneliminar.setText("ELIMINAR");
             btneliminar.setBounds(385,440,140,23);
             btneliminar.addActionListener(this);
             btneliminar.setEnabled(false);
             btneliminar.setBackground(new Color(0,102,153));
             
        
            
             Panel=new JScrollPane();
             getContentPane().add(Panel);
             Panel.setBounds(20,475,550,250);
            
             tablemodel=new DefaultTableModel(null,columnas);
             tabla=new JTable();
             Panel.setViewportView(tabla);
             tabla.addMouseListener(this);
             tabla.setModel(tablemodel);
             this.setSize(610,800);
             } catch (Exception e) {
             e.printStackTrace();
         }
    }
    public void CargarComboBox(){
            cboestado.addItem("---- SELECCIONAR ----");
            cboestado.addItem("HABILITADO");
            cboestado.addItem("DESHABILITADO");
    }
    
    public void Mostrar(){
            objfachada=new Fachada();
            
            cod=objfachada.generarcodigoprofesor();
            lista=objfachada.listaprofesor();
            //Se llena los datos
            if(cod==0){
             txtcodprofesor.setText(String.valueOf(1));
            }else{
             txtcodprofesor.setText(String.valueOf(cod));
            }
            txtcodprofesor.setEnabled(false);
            txtcodprofesor.setEnabled(false);
            int i=0;
            tablemodel.setNumRows(lista.size());
            String estado = "";
            for(ProfesorBean obj:lista){
                tablemodel.setValueAt(obj.getIdprofesor(), i,0);
                tablemodel.setValueAt(obj.getNombres(),i,1);
                tablemodel.setValueAt(obj.getDni(), i,2);
                tablemodel.setValueAt(obj.getCorreo(),i,3);
                tablemodel.setValueAt(obj.getTelefono(),i,4);
                tablemodel.setValueAt(obj.getDireccion(),i,5);
 
                if(obj.getEstado().equals("1")){
                   estado="HABILITADO";
                   tablemodel.setValueAt(estado, i, 6);
                }else{
                   estado="DESHABILITADO";
                   tablemodel.setValueAt(estado, i, 6);
                }
                i++;
            }
            CargarComboBox();
    }
    
    public void Grabar(){
            try {  
              objprofesorBean = new ProfesorBean();
              objprofesorBean.setIdprofesor(Integer.parseInt(txtcodprofesor.getText()));
              objprofesorBean.setNombres(txtnombres.getText());
              objprofesorBean.setDni(txtdni.getText());
              objprofesorBean.setCorreo(txtcorreo.getText());
              objprofesorBean.setTelefono(txttelefono.getText());
              objprofesorBean.setDireccion(txtdireccion.getText());
         
              if(cboestado.getSelectedItem().equals("HABILITADO")){
                  objprofesorBean.setEstado("1");
              }else{
                  objprofesorBean.setEstado("2");
              }
            objfachada=new Fachada();
            int i=objfachada.grabarprofesor(objprofesorBean);
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE GRABO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE GRABO CORRECTAMENTE");

           }
              } catch (Exception e) {
              e.printStackTrace();
          }
            Limpiar();
            Mostrar();
      }
    
    public void Modificar(){
            try {  
              objprofesorBean = new ProfesorBean();
              objprofesorBean.setIdprofesor(Integer.parseInt(txtcodprofesor.getText()));
              objprofesorBean.setNombres(txtnombres.getText());
              objprofesorBean.setDni(txtdni.getText());
              objprofesorBean.setCorreo(txtcorreo.getText());
              objprofesorBean.setTelefono(txttelefono.getText());
              objprofesorBean.setDireccion(txtdireccion.getText());

              if(cboestado.getSelectedItem().equals("HABILITADO")){
                  objprofesorBean.setEstado("1");
              }else{
                  objprofesorBean.setEstado("2");
              }
                objfachada=new Fachada();
            int i=objfachada.modificarprofesor(objprofesorBean);
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE MODIFICO CORRECTAMENTE");

              }
              } catch (Exception e) {
              e.printStackTrace();
          }
            Limpiar();
            Mostrar();
     }
    
    public void Limpiar(){          
                txtnombres.setText("");
                txtdni.setText("");
                txtcorreo.setText("");
                txttelefono.setText("");
                txtdireccion.setText("");

                cboestado.removeAllItems();
                txtnombres.requestFocus();
                btngrabar.setEnabled(true);
                btnmodificar.setEnabled(false);
                btneliminar.setEnabled(false);
    }
    
    public void Validacion(int x){
          try{
            if(txtcodprofesor.getText().equals("") ){
               JOptionPane.showMessageDialog(null, "INGRESE CODIGO NOTA");     
               }else if(txtnombres.getText().equals("")){
                   JOptionPane.showMessageDialog(null, "INGRESE NOMBRE");
                   txtnombres.requestFocus();
                   }else if(txtdni.getText().equals("")){
                      JOptionPane.showMessageDialog(null, "INGRESE DNI");
                      txtdni.requestFocus();
                      }else if(txtcorreo.getText().equals("")){
                         JOptionPane.showMessageDialog(null, "INGRESE CORREO");
                         txtcorreo.requestFocus();
                         }else if(txttelefono.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "INGRESE TELEFONO");
                            txttelefono.requestFocus();
                            }else if(txtdireccion.getText().equals("")){
                               JOptionPane.showMessageDialog(null, "INGRESE DIRECCION");
                               txtdireccion.requestFocus();
                           
                                     }else if(cboestado.getSelectedIndex()==0){
                                     JOptionPane.showMessageDialog(null, "SELECCIONE EL ESTADO");
                                     }else{
                                        switch(x){
                                          case 1:{
                                            Grabar();
                                            break;
                                            }
                                       } 
                                   }
                            }catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.toString());
                    }
             }
    public void Validacion2(int x){
          try{
            if(txtcodprofesor.getText().equals("") ){
               JOptionPane.showMessageDialog(null, "INGRESE CODIGO NOTA");     
               }else if(txtnombres.getText().equals("")){
                   JOptionPane.showMessageDialog(null, "INGRESE NOMBRE");
                   txtnombres.requestFocus();
                   }else if(txtdni.getText().equals("")){
                      JOptionPane.showMessageDialog(null, "INGRESE DNI");
                      txtdni.requestFocus();
                      }else if(txtcorreo.getText().equals("")){
                         JOptionPane.showMessageDialog(null, "INGRESE CORREO");
                         txtcorreo.requestFocus();
                         }else if(txttelefono.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "INGRESE TELEFONO");
                            txttelefono.requestFocus();
                            }else if(txtdireccion.getText().equals("")){
                               JOptionPane.showMessageDialog(null, "INGRESE DIRECCION");
                               txtdireccion.requestFocus();
                               
                                     }else if(cboestado.getSelectedIndex()==1){
                                     JOptionPane.showMessageDialog(null, "SELECCIONE EL ESTADO");
                                     }else{
                                        switch(x){
                                          case 2:{
                                            Modificar();
                                            break;
                                            }
                                       } 
                                   }
                            }catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.toString());
                    }
             }
    public void Seleccionar(){
             try{
               txtcodprofesor.setText(tabla.getValueAt(tabla.getSelectedRow(),0).toString());
               int cod=Integer.parseInt(txtcodprofesor.getText());
               objcargar=new ProfesorBean();
               objcargar.setIdprofesor(cod);
               objfachada=new Fachada();
           objcargar=objfachada.cargarprofesor(objcargar);
               txtcodprofesor.setText(String.valueOf(objcargar.getIdprofesor()));
               txtnombres.setText(String.valueOf(objcargar.getNombres()));
               txtdni.setText(String.valueOf(objcargar.getDni()));
               txtcorreo.setText(String.valueOf(objcargar.getCorreo()));
               txttelefono.setText(String.valueOf(objcargar.getTelefono()));
               txtdireccion.setText(String.valueOf(objcargar.getDireccion()));
          
               cboestado.removeAllItems();
               if(objcargar.getEstado().equals("1")){
                   cboestado.addItem("HABILITADO");
                   cboestado.addItem("---- SELECCIONAR ----");
                   cboestado.addItem("DESHABILITADO"); 
               }else{
                   cboestado.addItem("DESHABILITADO");
                   cboestado.addItem("---- SELECCIONAR ----");
                   cboestado.addItem("HABILITADO");
               }
               btngrabar.setEnabled(false);
               btnmodificar.setEnabled(true);
               btneliminar.setEnabled(true);

              }catch(Exception e){      
          }  
      }
    public void Eliminar(){       
              objeliminar=new ProfesorBean();
              objeliminar.setIdprofesor(Integer.parseInt(txtcodprofesor.getText()));
                   objfachada=new Fachada();
            int i=objfachada.eliminarprofesor(objprofesorBean);
              if(i==1){
               JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
           }else{
                              JOptionPane.showMessageDialog(null, "NO SE ELIMINO CORRECTAMENTE");

              }
              
              Limpiar();
              Mostrar();   
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btngrabar){
            Validacion(1);
        }
        if(e.getSource()==btnmodificar){
            Validacion2(2);
        }
        if(e.getSource()==btneliminar){
            Eliminar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tabla){             
            Seleccionar();
        }       
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
