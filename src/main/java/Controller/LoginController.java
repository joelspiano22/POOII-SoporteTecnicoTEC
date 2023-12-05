/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Login;
import Service.LoginRepository;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public class LoginController {
    public List<Login> getLstLoginController(){
        return new LoginRepository().getAllLogin();
    }
    
    public void addLogControl(Login log) {
        new LoginRepository().addLogin(log);
    }
    
    public boolean VerificarCredencialAdmin(String user, String pass) {
        return new LoginRepository().VerificarCredencialAdmin(user, pass);
    }
}
