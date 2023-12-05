/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;
import Model.Equipo;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public interface IEquipo {
    List<Equipo>getAllEquipo();
    void addEquipo(Equipo equi);
    void removeEquipo(Equipo equi);
    void updateEquipo(Equipo equi);
    Equipo busquedaIDEquipo(String cod);
    Equipo BusquedaEquipobyDescripcion(String des);
}
