/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
/**
 *
 * @author Rodrigo
 */
public class Soporte {
    private int IDSoporte;
    private double monto;
    private String Descripcion;
    private int IDCliente;
    private int IDEquipo;
    private int IDServicio;
    private String estado;
    private String solucion;

    public Soporte() {
    }

    public Soporte(int IDSoporte, double monto, String Descripcion, int IDCliente, int IDEquipo, int IDServicio, String estado, String solucion) {
        this.IDSoporte = IDSoporte;
        this.monto = monto;
        this.Descripcion = Descripcion;
        this.IDCliente = IDCliente;
        this.IDEquipo = IDEquipo;
        this.IDServicio = IDServicio;
        this.estado = estado;
        this.solucion = solucion;
    }

    public int getIDSoporte() {
        return IDSoporte;
    }

    public void setIDSoporte(int IDSoporte) {
        this.IDSoporte = IDSoporte;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDEquipo() {
        return IDEquipo;
    }

    public void setIDEquipo(int IDEquipo) {
        this.IDEquipo = IDEquipo;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
    
}  