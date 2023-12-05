/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.Cliente;
import Util.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection; /**/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Esteban Avendaño
 */
public class ClienteRepository implements ICliente{
    
    @Override
    public List<Cliente> getAllCliente(){
        try{
            /*Crear el arreglo dinamico*/
            List<Cliente> lstCliente = new ArrayList<>();
            /*Llamar o leer al store procedure*/
            CallableStatement sCli = Conexion.ObtenerConexion().prepareCall("{CALL UspListarCli()}");
            /*Asignar los datos de la base de datos a una estructura de datos ResultSet*/
            ResultSet rsCli = sCli.executeQuery();
            /*Recorrer el ResultSet y asignar los datos al arreglo de objetos*/
            while(rsCli.next())
            {
                Cliente objCli = new Cliente();/*Crear un Objeto*/
                objCli.setIDCliente(rsCli.getInt("id_cliente"));
                objCli.setNomCliente(rsCli.getString("nombre_cliente"));
                objCli.setApeCliente(rsCli.getString("apellido_cliente"));
                objCli.setDNICliente(rsCli.getInt("dni_cliente"));
                objCli.setDirCliente(rsCli.getString("direccion_cliente"));
                objCli.setTelefonoCliente(rsCli.getInt("telefono_cliente"));
                objCli.setUserCliente(rsCli.getString("userCliente"));
                objCli.setPassCliente(rsCli.getString("passCliente"));
                lstCliente.add(objCli);/*Asigno el Objeto a la lista*/            
            }
            Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
            rsCli.close();/*Cerrar el ResultSet*/
            return lstCliente;/*retornar el arreglo dinamico con los datos de la tabla EstadoCivil*/
        }catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    
    @Override
    public void addCliente(Cliente cli){
        try{
            PreparedStatement sCli = Conexion.ObtenerConexion().prepareStatement("{CALL UspInsertarCli(?,?,?,?,?,?,?,?)}");
            sCli.setInt(1, cli.getIDCliente());/*pasando los datos al parámetro del SP*/
            sCli.setString(2,cli.getNomCliente());
            sCli.setString(3,cli.getApeCliente());
            sCli.setInt(4, cli.getDNICliente());
            sCli.setString(5, cli.getDirCliente());
            sCli.setInt(6, cli.getTelefonoCliente());
            sCli.setString(7, cli.getUserCliente());
            sCli.setString(8, cli.getPassCliente());
            
            sCli.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void removeCliente(Cliente cli){
        try{
            PreparedStatement sCli = Conexion.ObtenerConexion().prepareStatement("{CALL UspRemoveCli(?)}");
            sCli.setInt(1, cli.getIDCliente());/*pasando los datos al parámetro del SP*/
            sCli.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void updateCliente(Cliente cli){
        try{
            PreparedStatement sCli = Conexion.ObtenerConexion().prepareStatement("{CALL UspUpdateCli(?,?,?,?,?,?,?,?)}");
            sCli.setInt(1, cli.getIDCliente());/*pasando los datos al parámetro del SP*/
            sCli.setString(2,cli.getNomCliente());
            sCli.setString(3,cli.getApeCliente());
            sCli.setInt(4, cli.getDNICliente());
            sCli.setString(5, cli.getDirCliente());
            sCli.setInt(6, cli.getTelefonoCliente());
            sCli.setString(7, cli.getUserCliente());
            sCli.setString(8, cli.getPassCliente());
            sCli.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public Cliente busquedaIDCliente(String cod) {
        Cliente objCli = new Cliente();  
        try{
            PreparedStatement sCli = Conexion.ObtenerConexion().prepareCall("{CALL UspBuscarClientebyID(?)}");
            sCli.setString(1, cod);
            ResultSet rsCli = sCli.executeQuery();
            if(rsCli.next())
            {
                
                objCli.setIDCliente(rsCli.getInt("id_cliente"));
                objCli.setNomCliente(rsCli.getString("nombre_cliente"));
                objCli.setApeCliente(rsCli.getString("apellido_cliente"));
                objCli.setDNICliente(rsCli.getInt("dni_cliente"));
                objCli.setDirCliente(rsCli.getString("direccion_cliente"));
                objCli.setTelefonoCliente(rsCli.getInt("telefono_cliente"));
                objCli.setUserCliente(rsCli.getString("userCliente"));
                objCli.setPassCliente(rsCli.getString("passCliente"));
                Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
                rsCli.close();
                return objCli;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return objCli;
    }
    
    @Override
    public boolean VerificarCredencialCli(String user, String pass) {
        try {
        Connection connection = Conexion.ObtenerConexion();
        
        PreparedStatement statement = connection.prepareCall("{CALL UspBuscarUsPa(?, ?)}");
        statement.setString(1, user);
        statement.setString(2, pass);

        ResultSet resultSet = statement.executeQuery();
        
        boolean credencialesValidas = resultSet.next();
        
        resultSet.close();
        statement.close();
        connection.close();

        return credencialesValidas;

        }catch(Exception e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public Cliente busquedaClientebyUserPass(String user, String pass) {
        
        try{
            PreparedStatement sCli = Conexion.ObtenerConexion().prepareCall("{CALL UspBusquedaClientebyUserPass(?,?)}");
            sCli.setString(1, user);
            sCli.setString(2, pass);
            ResultSet rsCli = sCli.executeQuery();
            if(rsCli.next())
            {
                Cliente objCli = new Cliente();
                objCli.setIDCliente(rsCli.getInt("id_cliente"));
                objCli.setNomCliente(rsCli.getString("nombre_cliente"));
                objCli.setApeCliente(rsCli.getString("apellido_cliente"));
                objCli.setDNICliente(rsCli.getInt("dni_cliente"));
                objCli.setDirCliente(rsCli.getString("direccion_cliente"));
                objCli.setTelefonoCliente(rsCli.getInt("telefono_cliente"));
                objCli.setUserCliente(rsCli.getString("userCliente"));
                objCli.setPassCliente(rsCli.getString("passCliente"));
                Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
                
                rsCli.close();
                sCli.close();
                Conexion.ObtenerConexion().close();
                
                return objCli;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    
}
