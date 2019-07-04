package gestionusuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UsuarioDAO {
    private Conexion conexion = new Conexion();

    public UsuarioDAO() {
    }
    public void AgregarUsuario(Usuario usuario) {
        //Cargar la Conexion
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "INSERT INTO usuario (IdUsuario,NombreUsuario,password,permisos) "
                + "VALUES ('" + usuario.getIdUsuario() + "','" + usuario.getNombreUsuario() + "','" + usuario.getPassword() + "','" + usuario.getPermisos() +"')";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Registro creado!!!");
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se puede registrar usuario");
        }

    }


    public void EliminarUsuario(String n) {
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "DELETE FROM usuario WHERE IdUsuario='" + n + "'";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null,"Registro eliminado con exito!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Error no existe usuario");
            }
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se elimino el usuario");
        }
    }

    
     public ArrayList<Usuario> login(String user, String clave){
    
        
        Connection conectar = conexion.getConnection();
        Statement pst;
        ResultSet rs ;
        Usuario cuenta ;
        ArrayList list = new ArrayList();
        
        try{
            // obtenemos la conexion con la base de datos
            pst = conectar.createStatement();
            if(conectar != null){
                
                String sql ="SELECT IdUsuario, Password FROM usuario WHERE IdUsuario ='"+user+"' AND Password='"+clave+"'";
                pst = conectar.prepareStatement(sql);                
                rs = pst.executeQuery(sql);
                                
                if(rs.next()){                    
                    cuenta = new Usuario();
                    cuenta.setIdUsuario(rs.getString("IdUsuario"));
                    cuenta.setPassword(rs.getString("Password"));                    
                    list.add(cuenta);
                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al realizar la operacion, intente mas tarde","ERROR",JOptionPane.ERROR_MESSAGE);
            }
                
        
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e , " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
        }finally{
        
            try{
                conectar.close();
            }catch(SQLException ex){
                System.out.println("error "+ex);
            }
        
        }
        
       return list;
         
    }    
}
