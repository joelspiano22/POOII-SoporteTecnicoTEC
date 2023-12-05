package Controller;
import Model.Servicio;
import Service.ServicioRepository;
import java.util.List;

public class ServicioController {
    public List<Servicio> getLstServicioController(){
        return new ServicioRepository().getAllServicio();
    }
    
    public void addServicioControl(Servicio ser){
        new ServicioRepository().addServicio(ser);
    }
    
    public void removeServicioControl(Servicio ser){
        new ServicioRepository().removeServicio(ser);
    }
    
    public void updateServicioControl(Servicio ser){
        new ServicioRepository().updateServicio(ser);
    }
        public Servicio busquedaClibyID(String c){
        return new ServicioRepository().busquedaIDServicio(c);
    }
    public Servicio BusquedaServiciobyDescripcion(String des){
        return new ServicioRepository().BusquedaServiciobyDescripcion(des);
    }
}