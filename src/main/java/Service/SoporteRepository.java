package Service;

import Model.Soporte;
import Util.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SoporteRepository implements ISoporte{
    @Override
    public List<Soporte> getAllSoporte(){
        try{
            /*Crear el arreglo dinamico*/
            List<Soporte> lstSoporte = new ArrayList<>();
            /*Llamar o leer al store procedure*/
            CallableStatement sSop = Conexion.ObtenerConexion().prepareCall("{CALL UspListarSop()}");
            /*Asignar los datos de la base de datos a una estructura de datos ResultSet*/
            ResultSet rsSop = sSop.executeQuery();
            /*Recorrer el ResultSet y asignar los datos al arreglo de objetos*/
            while(rsSop.next())
            {
                Soporte objSop = new Soporte();/*Crear un Objeto*/
                objSop.setIDSoporte(rsSop.getInt("id_soporte"));
                objSop.setMonto(rsSop.getDouble("monto_soporte"));
                objSop.setDescripcion(rsSop.getString("descripcion_soporte"));
                objSop.setIDCliente(rsSop.getInt("id_cliente"));
                objSop.setIDEquipo(rsSop.getInt("id_equipo"));
                objSop.setIDServicio(rsSop.getInt("id_servicio"));
                objSop.setEstado(rsSop.getString("estado_soporte"));
                objSop.setSolucion(rsSop.getString("solucion_soporte"));
             
                lstSoporte.add(objSop);/*Asigno el Objeto a la lista*/            
            }
            Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
            rsSop.close();/*Cerrar el ResultSet*/
            return lstSoporte;/*retornar el arreglo dinamico con los datos de la tabla EstadoCivil*/
        }catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    
    @Override
    public void addSoporte(Soporte sop){
        try{
            PreparedStatement sSop = Conexion.ObtenerConexion().prepareStatement("{CALL UspInsertarSop(?,?,?,?,?,?,?,?)}");
            sSop.setInt(1, sop.getIDSoporte());/*pasando los datos al parámetro del SP*/
            sSop.setDouble(2,sop.getMonto());
            sSop.setString(3, sop.getDescripcion());
            sSop.setInt(4, sop.getIDCliente());
            sSop.setInt(5, sop.getIDEquipo());
            sSop.setInt(6, sop.getIDServicio());
            sSop.setString(7, sop.getEstado());
            sSop.setString(8, sop.getSolucion());
            sSop.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void removeSoporte(Soporte sop){
        try{
            PreparedStatement sSop = Conexion.ObtenerConexion().prepareStatement("{CALL UspRemoveSop(?)}");
            sSop.setInt(1, sop.getIDSoporte());/*pasando los datos al parámetro del SP*/
            sSop.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public void updateSoporte(Soporte sop){
        try{
            PreparedStatement sSop = Conexion.ObtenerConexion().prepareStatement("{CALL UspUpdateSop(?,?,?,?,?,?,?,?)}");
            sSop.setInt(1, sop.getIDSoporte());/*pasando los datos al parámetro del SP*/
            sSop.setDouble(2,sop.getMonto());
            sSop.setString(3, sop.getDescripcion());
            sSop.setInt(4, sop.getIDCliente());
            sSop.setInt(5, sop.getIDEquipo());
            sSop.setInt(6, sop.getIDServicio());
            sSop.setString(7, sop.getEstado());
            sSop.setString(8, sop.getSolucion());
            sSop.executeUpdate();/*Actualizar la BD*/
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public Soporte BusquedaSoportebyID(String id) {
        Soporte objSop = new Soporte();
        try{
            
            PreparedStatement sSer = Conexion.ObtenerConexion().prepareCall("{CALL UspBuscarSop(?)}");
            sSer.setString(1, id);
            ResultSet rsSop = sSer.executeQuery();
            if(rsSop.next())
            {
                objSop.setIDSoporte(rsSop.getInt("id_soporte"));
                objSop.setMonto(rsSop.getDouble("monto_soporte"));
                objSop.setDescripcion(rsSop.getString("descripcion_soporte"));
                objSop.setIDCliente(rsSop.getInt("id_cliente"));
                objSop.setIDEquipo(rsSop.getInt("id_equipo"));
                objSop.setIDServicio(rsSop.getInt("id_servicio"));
                objSop.setEstado(rsSop.getString("estado_soporte"));
                objSop.setSolucion(rsSop.getString("solucion_soporte"));
                Conexion.ObtenerConexion().close();/*Cerrar la Conexion*/
                rsSop.close();
                sSer.close();
                return objSop;
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return objSop;
    }
}
