/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Cliente;
import Service.ClienteRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public class ClienteController {
    private ArrayList<Cliente> cli;

    public List<Cliente> getLstClienteController()
    {
        return new ClienteRepository().getAllCliente();
    }
    
    public void addCliControl(Cliente cli){
        new ClienteRepository().addCliente(cli);
    }
    
    public void removeCliControl(Cliente cli){
        new ClienteRepository().removeCliente(cli);
    }
    
    public void updateCliControl(Cliente cli){
        new ClienteRepository().updateCliente(cli);
    }
    public Cliente busquedaClibyID(String c){
        return new ClienteRepository().busquedaIDCliente(c);
    }
    
    public boolean VerificarCredencialCli(String user, String pass) {
        return new ClienteRepository().VerificarCredencialCli(user, pass);
    }
    public Cliente busquedaClientebyUserPass(String user, String pass){
        return new ClienteRepository().busquedaClientebyUserPass(user, pass);
    }
    
    //El tamaño total de los elementos de la lista
    public int tamaño(){
      return cli.size();
    }
    
    public int getCorrelativo(){
       /*ArrayList vacio  1  2  3  4*/
       if(tamaño() == 0)
           return 1;
       else{
          return tamaño() + 1;
       }
    }
}
