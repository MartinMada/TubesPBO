/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Admin;
import model.Person;
import model.User;

/**
 *
 * @author Darren
 */
public class Access {
    public void login(String name, String password) {
        DatabaseHandler.getInstance().connect();
        String query = "SELECT * FROM person WHERE name='" + name + "' AND password='" + password + "'";
        Person person = null;
        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String checkAdmin = "SELECT * FROM admin WHERE id='" + rs.getInt("id") + "'";
                Statement stmtCheckAdmin = DatabaseHandler.getInstance().con.createStatement();
                ResultSet rsCheckAdmin = stmtCheckAdmin.executeQuery(checkAdmin);
                while (rsCheckAdmin.next()) {
                    person = new Admin(rs.getInt("id"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("pic_path"), null, null);
                }
                
                if (person == null) {
                    String checkUser = "SELECT * FROM user WHERE id='" + rs.getInt("id") + "'";
                    Statement stmtCheckUser = DatabaseHandler.getInstance().con.createStatement();
                    ResultSet rsCheckUser = stmtCheckUser.executeQuery(checkUser);
                    while (rsCheckUser.next()) {
                        person = new User(rs.getInt("id"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("pic_path"), rsCheckUser.getString("bio"), null, rsCheckUser.getInt("warning"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SingletonManager.getInstance().setPerson(person);
    }
    
    public void logoff(){
        SingletonManager.getInstance().setPerson(null);
    }
}
