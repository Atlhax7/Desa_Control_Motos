package gestionusuarios;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class controlador implements ActionListener{

    private final MenuLogin view ;
    private final UsuarioDAO model=new UsuarioDAO();
    
    public final void events(){
        view.btn_enter.addActionListener(this);
        view.btn_exit.addActionListener(this);
        view.checkviewpass.addActionListener(this);
    }
    
    public controlador(MenuLogin vista){
        this.view=vista;
        events();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object evt = e.getSource();
       
        if(evt.equals(view.btn_enter)){
            
           // String clave=view.txt_user1.getText();
            String clavedef=new String(view.txt_user1.getText());
        
            if(clavedef.isEmpty() || view.txt_user.getText().isEmpty()){

                JOptionPane.showMessageDialog(null, "Debe digitar un Usuario y una Contraseña", "Error en la Operación", JOptionPane.ERROR_MESSAGE);

            }else{
                ArrayList<Usuario> list;
                model.login(view.txt_user.getText(), clavedef);
                list = model.login(view.txt_user.getText(), clavedef);                
                if(list.size()>0){
                    
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "INFO.", JOptionPane.INFORMATION_MESSAGE);
                    view.dispose();
                    VistaUsuario inicio = new VistaUsuario();
                    inicio.setVisible(true);
                    
                }else{

                    JOptionPane.showMessageDialog(null, "Acceso denegado", "ERR.", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }
            
            
        }else if(evt.equals(view.btn_exit)){
            
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta Seguro Que Desea Salir Del Sistema?");
            
            if(confirmar==JOptionPane.YES_OPTION){
                System.exit(0);
            }
                        
        }else if(evt.equals(view.checkviewpass)){
          /*  
            if(view.checkviewpass.isSelected()){
                view.txt_user1.(char)0);
            }else{
                view.txt_user1.setEchoChar('*');                
            }*/
            
        }

        
        
    }

    

    
}
