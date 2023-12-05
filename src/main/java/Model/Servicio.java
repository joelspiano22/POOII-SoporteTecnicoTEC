/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rodrigo
 */
public class Servicio {
    private int IDServicio;
    private String DesServicio;
    private double PreServicio;

    public Servicio(int IDServicio, String DesServicio, double PreServicio) {
        this.IDServicio = IDServicio;
        this.DesServicio = DesServicio;
        this.PreServicio = PreServicio;
    }
    
    public Servicio(){
        
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public String getDesServicio() {
        return DesServicio;
    }

    public void setDesServicio(String DesServicio) {
        this.DesServicio = DesServicio;
    }

    public double getPreServicio() {
        return PreServicio;
    }

    public void setPreServicio(double PreServicio) {
        this.PreServicio = PreServicio;
    }

    
}
