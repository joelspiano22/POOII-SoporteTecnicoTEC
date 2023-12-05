/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rodrigo
 */
public class Equipo {
    private int IDEquipo;
    private String DesEquipo;

    public Equipo() {
    }

    public Equipo(int IDEquipo, String DesEquipo) {
        this.IDEquipo = IDEquipo;
        this.DesEquipo = DesEquipo;
    }

    public int getIDEquipo() {
        return IDEquipo;
    }

    public void setIDEquipo(int IDEquipo) {
        this.IDEquipo = IDEquipo;
    }

    public String getDesEquipo() {
        return DesEquipo;
    }

    public void setDesEquipo(String DesEquipo) {
        this.DesEquipo = DesEquipo;
    }
    
}
