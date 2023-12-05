/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Equipo;
import Service.EquipoRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public class EquipoController {
    private ArrayList<Equipo> equi;
    
    public List<Equipo> getLstEquipoController(){
        return new EquipoRepository().getAllEquipo();
    }
    
    public void addEquipoControl(Equipo equi){
        new EquipoRepository().addEquipo(equi);
    }
    
    public void removeEquipoControl(Equipo equi){
        new EquipoRepository().removeEquipo(equi);
    }
    
    public void updateEquipoControl(Equipo equi){
        new EquipoRepository().updateEquipo(equi);
    }
    
    public Equipo busquedaEquibyID(String c){
        return new EquipoRepository().busquedaIDEquipo(c);
    }
    
    public Equipo BusquedaEquipobyDescripcion(String des){
        return new EquipoRepository().BusquedaEquipobyDescripcion(des);
    }
        
    //El tamaño total de los elementos de la lista
    /*public int tamaño(){
      return equi.size();
    }*/
    
    /*public int getCorrelativo(){
       /*ArrayList vacio  1  2  3  4*/
       /*if(tamaño() == 0)
           return 1;
       else{
          return tamaño() + 1;
       }
    }*/
}
