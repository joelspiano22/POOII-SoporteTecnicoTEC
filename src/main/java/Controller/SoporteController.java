package Controller;

import Model.Soporte;
import Service.SoporteRepository;
import java.util.List;

public class SoporteController {
    public List<Soporte> getLstSoporteController()
    {
        return new SoporteRepository().getAllSoporte();
    }
    
    public void addSopControl(Soporte sop){
        new SoporteRepository().addSoporte(sop);
    }
    
    public void removeSopControl(Soporte cli){
        new SoporteRepository().removeSoporte(cli);
    }
    
    public void updateSopControl(Soporte cli){
        new SoporteRepository().updateSoporte(cli);
    }
    public Soporte BusquedaSoportebyID(String id){
        return new SoporteRepository().BusquedaSoportebyID(id);
    }
}
