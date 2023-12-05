package Service;
import Model.Servicio;
import Util.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioRepository implements IServicio{
    
    @Override
    public List<Servicio> getAllServicio() {
       try{
           /*Crear el arreglo dinamico*/
            List<Servicio> lstSer = new ArrayList<>();
            /*Llamar o leer al store procedure*/
            CallableStatement sSer = Conexion.ObtenerConexion().prepareCall("{CALL UspListarSer()}");
            /*Asignar los datos de la base de datos a una estructura de datos ResultSet*/
            ResultSet rsSer = sSer.executeQuery();
            /*Recorrer el ResultSet y asignar los datos al arreglo de objetos*/
            while(rsSer.next()){
                Servicio objSer = new Servicio();
                objSer.setIDServicio(rsSer.getInt("id_servicio"));
                objSer.setDesServicio(rsSer.getString("descripcion_servicio"));
                objSer.setPreServicio(rsSer.getDouble("precio_servicio"));
                
                lstSer.add(objSer);
            }
            Conexion.ObtenerConexion().close();/*Cerrar la conexion*/
            rsSer.close();/*Cerrar el ResultSet*/
            return lstSer;
       } catch(Exception e){
           e.getMessage();
       }
       return null;
    }
    
    public void addServicio(Servicio ser){
        try{
            PreparedStatement sSer = Conexion.ObtenerConexion().prepareStatement("{CALL UspInsertarSer(?,?,?)}");
            sSer.setInt(1, ser.getIDServicio());/*pasando los datos al parámetro del SP*/
            sSer.setString(2, ser.getDesServicio());
            sSer.setDouble(3, ser.getPreServicio());
            sSer.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void removeServicio(Servicio ser){
        try{
            PreparedStatement sSer = Conexion.ObtenerConexion().prepareStatement("{CALL UspRemoveSer(?)}");
            sSer.setInt(1, ser.getIDServicio());/*pasando los datos al parámetro del SP*/
            sSer.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void updateServicio(Servicio ser){
        try{
            PreparedStatement sSer = Conexion.ObtenerConexion().prepareStatement("{CALL UspUpdateSer(?,?,?)}");
            sSer.setInt(1, ser.getIDServicio());/*pasando los datos al parámetro del SP*/
            sSer.setString(2, ser.getDesServicio());
            sSer.setDouble(3, ser.getPreServicio());
            sSer.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public Servicio busquedaIDServicio(String cod) {
        Servicio objSer = new Servicio();
        try{
            
            PreparedStatement sSer = Conexion.ObtenerConexion().prepareCall("{CALL UspBuscarServiciobyID(?)}");
            sSer.setString(1, cod);
            ResultSet rsSer = sSer.executeQuery();
            if(rsSer.next())
            {
                objSer.setIDServicio(rsSer.getInt("id_servicio"));
                objSer.setDesServicio(rsSer.getString("descripcion_servicio"));
                objSer.setPreServicio(rsSer.getDouble("precio_servicio"));
                Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
                rsSer.close();
                return objSer;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return objSer;
    }

    @Override
    public Servicio BusquedaServiciobyDescripcion(String des) {        
        try{
            
            PreparedStatement sSer = Conexion.ObtenerConexion().prepareCall("{CALL UspBuscarServiciobyDescripcion(?)}");
            sSer.setString(1, des);
            ResultSet rsSer = sSer.executeQuery();
            if(rsSer.next())
            {
                Servicio objSer = new Servicio();
                objSer.setIDServicio(rsSer.getInt("id_servicio"));
                objSer.setDesServicio(rsSer.getString("descripcion_servicio"));
                objSer.setPreServicio(rsSer.getDouble("precio_servicio"));
                Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
                rsSer.close();
                sSer.close();
                return objSer;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    
}