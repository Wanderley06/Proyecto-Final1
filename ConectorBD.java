/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
        
public class ConectorBD {
    
    Connection conectar=null;
    
   public Connection getConnection() throws ClassNotFoundException{
   
   try {
       Class.forName("com.mysql.jdbc.Driver");
       conectar=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "informatica");
       
   }catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error de Conexion" +e.getMessage());
   }
   return conectar;
   } 

    com.mysql.jdbc.Connection conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
