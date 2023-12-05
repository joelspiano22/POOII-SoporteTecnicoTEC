/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Cliente;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public interface ICliente {
    List<Cliente>getAllCliente();
    void addCliente(Cliente cli);
    void removeCliente(Cliente cli);
    void updateCliente(Cliente cli);
    Cliente busquedaIDCliente(String cod);
    boolean VerificarCredencialCli(String user, String pass);
    Cliente busquedaClientebyUserPass(String user, String pass);
}
