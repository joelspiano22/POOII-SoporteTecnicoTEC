/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.Login;
import Util.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public class LoginRepository implements ILogin {
    
    public List<Login>getAllLogin() {
        try{
            /*Crear el arreglo dinamico*/
            List<Login> lstLog = new ArrayList<>();
            /*Llamar o leer al store procedure*/
            CallableStatement sLog = Conexion.ObtenerConexion().prepareCall("{CALL USPListarAdmin()}");
            /*Asignar los datos de la base de datos a una estructura de datos ResultSet*/
            ResultSet rsLog = sLog.executeQuery();
            /*Recorrer el ResultSet y asignar los datos al arreglo de objetos*/
            while(rsLog.next()) {
                Login objLog = new Login();
                objLog.setIDLogin(rsLog.getInt("id_admin"));
                objLog.setUser(rsLog.getString("user_admin"));
                objLog.setPassword(rsLog.getString("password_admin"));
                
                lstLog.add(objLog); /*Asignar el objeto a la lista*/
            }
            Conexion.ObtenerConexion().close();
            rsLog.close();
            return lstLog;
        }catch(Exception e){
            e.getMessage();
        }
        return null;
        
    }
    
    public void addLogin(Login log) {
        try{
            PreparedStatement sLog = Conexion.ObtenerConexion().prepareStatement("{CALL UspInsertarAdmin(?,?,?)}");
            sLog.setInt(1, log.getIDLogin());/*pasando los datos al parámetro del SP*/
            sLog.setString(2,log.getUser());
            sLog.setString(3, log.getPassword());
            sLog.executeUpdate(); /*Actualizar la BD*/
        }catch(Exception e) {
            e.getMessage();
        }
    }
    
    
    public boolean VerificarCredencialAdmin(String user, String pass) {
        try {
        Connection connection = Conexion.ObtenerConexion();
        
        PreparedStatement statement = connection.prepareCall("{CALL UspBuscarUsPaAdmin(?, ?)}");
        statement.setString(1, user);
        statement.setString(2, pass);

        ResultSet resultSet = statement.executeQuery();
        
        boolean credencialesValidasA = resultSet.next();
        
        resultSet.close();
        statement.close();
        connection.close();

        return credencialesValidasA;

        }catch(Exception e) {
            e.getMessage();
        }
        return false;
    }
    
}
