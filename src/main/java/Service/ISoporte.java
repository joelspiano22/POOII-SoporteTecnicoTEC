package Service;
import Model.Soporte;
import java.util.List;

public interface ISoporte {
    List<Soporte>getAllSoporte();
    void addSoporte(Soporte sop);
    void removeSoporte(Soporte sop);
    void updateSoporte(Soporte sop);
    public Soporte BusquedaSoportebyID(String id);
}
