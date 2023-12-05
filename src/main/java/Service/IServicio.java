package Service;

import Model.Servicio;
import java.util.List;

public interface IServicio {
    List<Servicio>getAllServicio();
    void addServicio(Servicio ser);
    void removeServicio(Servicio ser);
    void updateServicio(Servicio ser);
    Servicio busquedaIDServicio(String cod);
    Servicio BusquedaServiciobyDescripcion(String des);
}