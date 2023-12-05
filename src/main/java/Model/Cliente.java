/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rodrigo
 */
public class Cliente {
    private int IDCliente;
    private String NomCliente;
    private String ApeCliente;
    private int DNICliente;
    private String DirCliente;
    private int TelefonoCliente;
    private String userCliente;
    private String passCliente;

    public Cliente() {
    }

    public Cliente(int IDCliente, String NomCliente, String ApeCliente, int DNICliente, String DirCliente, int TelefonoCliente, String userCliente, String passCliente) {
        this.IDCliente = IDCliente;
        this.NomCliente = NomCliente;
        this.ApeCliente = ApeCliente;
        this.DNICliente = DNICliente;
        this.DirCliente = DirCliente;
        this.TelefonoCliente = TelefonoCliente;
        this.userCliente = userCliente;
        this.passCliente = passCliente;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNomCliente() {
        return NomCliente;
    }

    public void setNomCliente(String NomCliente) {
        this.NomCliente = NomCliente;
    }

    public String getApeCliente() {
        return ApeCliente;
    }

    public void setApeCliente(String ApeCliente) {
        this.ApeCliente = ApeCliente;
    }

    public int getDNICliente() {
        return DNICliente;
    }

    public void setDNICliente(int DNICliente) {
        this.DNICliente = DNICliente;
    }

    public String getDirCliente() {
        return DirCliente;
    }

    public void setDirCliente(String DirCliente) {
        this.DirCliente = DirCliente;
    }

    public int getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(int TelefonoCliente) {
        this.TelefonoCliente = TelefonoCliente;
    }

    public String getUserCliente() {
        return userCliente;
    }

    public void setUserCliente(String userCliente) {
        this.userCliente = userCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }

    
}
