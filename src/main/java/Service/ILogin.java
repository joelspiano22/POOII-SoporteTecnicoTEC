/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;
import Model.Login;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */
public interface ILogin {
    List<Login>getAllLogin();
    void addLogin(Login log);
    boolean VerificarCredencialAdmin(String user, String pass);
}
