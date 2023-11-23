/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Enum.Genre;

/**
 *
 * @author marti
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    // SELECT ALL from table users
//    public ArrayList<User> getAllUsers() {
//        ArrayList<User> users = new ArrayList<>();
//        try {
//            conn.connect();
//            String query = "SELECT * FROM users";
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt("ID"));
//                user.setName(rs.getString("Name"));
//                user.setAddress(rs.getString("Address"));
//                user.setPhone(rs.getString("Phone"));
//                user.setAge(rs.getInt("Age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            System.out.println("MASUK CATCH GET ALL USERS : ");
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            System.out.println("MASUK CATCH GET ALL USERS NULL : ");
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("MASUK CATCH GET ALL USERS NULL : ");
//            e.printStackTrace();
//        }
//        conn.disconnect();
//        return (users);
//    }

    // SELECT WHERE
    public Person getUser(String name, String password) {
        conn.connect();
        String query = "SELECT * FROM person WHERE name='" + name + "' AND pass='" + password + "'";
        Person person = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("pass"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
                return person;                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (person);
    }
    
    // INSERT
//    public boolean insertNewUser(User user) {
//        conn.connect();
//        String query = "INSERT INTO users VALUES(?,?,?,?,?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setInt(1, user.getId());
//            stmt.setString(2, user.getName());
//            stmt.setString(3, user.getAddress());
//            stmt.setString(4, user.getPhone());
//            stmt.setInt(5, user.getAge());
//            stmt.executeUpdate();
//            conn.disconnect();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            conn.disconnect();
//            return (false);
//        }
//    }

    // UPDATE
//    public boolean updateUser(User user) {
//        conn.connect();
//        String query = "UPDATE users SET Name='" + user.getName() + "', "
//                + "Address='" + user.getAddress() + "', "
//                + "Phone='" + user.getPhone() + "' "
//                + "WHERE ID='" + user.getId() + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            conn.disconnect();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            conn.disconnect();
//            return (false);
//        }
//    }

    // DELETE
//    public boolean deleteUser(String name) {
//        conn.connect();
//
//        String query = "DELETE FROM users WHERE Name='" + name + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            conn.disconnect();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            conn.disconnect();
//            return (false);
//        }
//    }
}
