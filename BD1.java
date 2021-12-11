package BD;

import Clases.usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class BD1 {
    private static Connection mConection;
     private static Statement mStatement;
     private static ResultSet mResultSet;
      private final String BD;
       private final String user;
       private final String password;

    public BD1(String BD, String user, String password) {
        mConection = null;
        mStatement = null;
       mResultSet = null;
        this.BD = BD;
        this.user = user;
        this.password = password;
    }
       
       public boolean Conectar(){
           try {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               mConection = DriverManager.getConnection("jdbc:Mysql://localhost:3306/" + BD , user, password);
               return mConection != null;
           }catch (Exception e){
               return false;
           }
           
       }
       
       public void desconectar(){
           try {
               this.mConection.close();
           }catch (Exception e) {
               
           }
       }
       
       public boolean AddUser(usuario mUsuario){
           try {
               mStatement = mConection.createStatement();
               mStatement.execute("INSERT INTO usuarios (Nombre_usuario, Nombre, Apellido, Telefono, Correo_electrónico,Contraseña)"
               +"VALUES ('"+ mUsuario.getNombre_usuario() + "', '"+ mUsuario.getNombre() + "', '"+ mUsuario.getApellido() + "', '"+ mUsuario.getTelefono(
               ) + "', '"+ mUsuario.getCorreo_electrónico() + "', '"+ mUsuario.getContraseña() + "')");
               return true;
           }catch (SQLException e){
               System.err.println(e.toString());
             return false;
           }
           
         }
       
       public usuario GetUsuario(String usuario){
         usuario mUsuario = null;
         try {
             mStatement = mConection.createStatement();
             mResultSet = mStatement.executeQuery("SELECT * FROM usuarios WHERE usuario = '" + usuario + "' ");
             while(mResultSet.next()){
                 mUsuario = new usuario();
                 mUsuario.setNombre_usuario(mResultSet.getString("Nombre_usuario"));
                  mUsuario.setNombre(mResultSet.getString("Nombre"));
                  mUsuario.setApellido(mResultSet.getString("Apellido"));
                  mUsuario.setTelefono(mResultSet.getString("Telefono"));
                  mUsuario.setCorreo_electrónico(mResultSet.getString("Correo_electronico"));
                  mUsuario.setContraseña(mResultSet.getString("Contraseña"));
                 return mUsuario;
             }
         }catch (SQLException e) {
             return null;
         }
         return mUsuario;
     
       }
    
}

