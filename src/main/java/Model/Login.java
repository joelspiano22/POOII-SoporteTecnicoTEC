/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Esteban Avendaño
 */
public class Login {
    private int IDLogin;
    private String user;
    private String password;
    
    public Login() {
        
    }

    public Login(int IDLogin, String user, String password) {
        this.IDLogin = IDLogin;
        this.user = user;
        this.password = password;
    }

    public int getIDLogin() {
        return IDLogin;
    }

    public void setIDLogin(int IDLogin) {
        this.IDLogin = IDLogin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
