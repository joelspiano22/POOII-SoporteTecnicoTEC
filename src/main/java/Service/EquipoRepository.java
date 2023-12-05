/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.Equipo;
import Util.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public class EquipoRepository implements IEquipo{
    
    @Override
    public List<Equipo> getAllEquipo() {
       try{
           /*Crear el arreglo dinamico*/
            List<Equipo> lstEqui = new ArrayList<>();
            /*Llamar o leer al store procedure*/
            CallableStatement sEqui = Conexion.ObtenerConexion().prepareCall("{CALL USPListarEquipo()}");
            /*Asignar los datos de la base de datos a una estructura de datos ResultSet*/
            ResultSet rsEqui = sEqui.executeQuery();
            /*Recorrer el ResultSet y asignar los datos al arreglo de objetos*/
            while(rsEqui.next()){
                Equipo objEqui = new Equipo();
                objEqui.setIDEquipo(rsEqui.getInt("id_equipo"));
                objEqui.setDesEquipo(rsEqui.getString("descripcion_equipo"));
                
                lstEqui.add(objEqui);
            }
            Conexion.ObtenerConexion().close();/*Cerrar la conexion*/
            rsEqui.close();/*Cerrar el ResultSet*/
            return lstEqui;
       } catch(Exception e){
           e.getMessage();
       }
       return null;
    }
    
    public void addEquipo(Equipo equi){
        try{
            PreparedStatement sEqui = Conexion.ObtenerConexion().prepareStatement("{CALL UspInsertarEquipo(?,?)}");
            sEqui.setInt(1, equi.getIDEquipo());/*pasando los datos al parámetro del SP*/
            sEqui.setString(2, equi.getDesEquipo());
            sEqui.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void removeEquipo(Equipo equi){
        try{
            PreparedStatement sEqui = Conexion.ObtenerConexion().prepareStatement("{CALL UspRemoveEquipo(?)}");
            sEqui.setInt(1, equi.getIDEquipo());/*pasando los datos al parámetro del SP*/
            sEqui.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void updateEquipo(Equipo equi){
        try{
            PreparedStatement sEqui = Conexion.ObtenerConexion().prepareStatement("{CALL UspUpdateEquipo(?,?)}");
            sEqui.setInt(1, equi.getIDEquipo());/*pasando los datos al parámetro del SP*/
            sEqui.setString(2, equi.getDesEquipo());
            sEqui.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public Equipo busquedaIDEquipo(String cod) {
        Equipo objEqui = new Equipo();
        try{
            
            PreparedStatement sEqui = Conexion.ObtenerConexion().prepareCall("{CALL UspBuscarEquipobyID(?)}");
            sEqui.setString(1, cod);
            ResultSet rsEqui = sEqui.executeQuery();
            if(rsEqui.next())
            {
                objEqui.setIDEquipo(rsEqui.getInt("id_equipo"));
                objEqui.setDesEquipo(rsEqui.getString("descripcion_equipo"));
                Conexion.ObtenerConexion().close(); /*Cerrar la Conexion*/
                rsEqui.close();
                return objEqui;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return objEqui;
    }
    
    public Equipo BusquedaEquipobyDescripcion(String des) {
        try{
            PreparedStatement sEqui = Conexion.ObtenerConexion().prepareCall("{CALL UspBuscarEquipobyDescripcion(?)}");
            sEqui.setString(1, des);
            ResultSet rsEqui = sEqui.executeQuery();
            if(rsEqui.next())
            {
                Equipo objEqui = new Equipo();
                objEqui.setIDEquipo(rsEqui.getInt("id_equipo"));
                objEqui.setDesEquipo(rsEqui.getString("descripcion_equipo"));
                Conexion.ObtenerConexion().close(); /*Cerrar la Conexion*/
                rsEqui.close();
                sEqui.close();
                return objEqui;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return null;
    }
}
