/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Controller.DatabaseHandler;
import model.Person;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.User;

/**
 *
 * @author marti
 */
public class GUILogin {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JTextField fieldUsername;
    private JPasswordField fieldPass;
    private JLabel labelUsername;
    private JLabel labelPass;
    private JButton loginbtn;
    
    static DatabaseHandler conn = new DatabaseHandler();
    
    public GUILogin(){
        Controller cntrl = new Controller();
        frame = new JFrame("Login");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("Login");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(title,new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        
        labelUsername = new JLabel("Username");
        labelUsername.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelUsername,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));
        
        fieldUsername = new JTextField();
        panel.add(fieldUsername,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 300, 20));
        
        labelPass = new JLabel("Password");
        labelPass.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelPass,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        
        fieldPass = new JPasswordField();
        panel.add(fieldPass,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 300, 20));
        
        loginbtn = new JButton("Login");
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = cntrl.getUser(fieldUsername.getText(),fieldPass.getPassword().toString());
                if (user != null && user.getPassword().equals(new String(fieldPass.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Sukses", "Info", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new GUIHomeUser();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal. Email atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        panel.add(loginbtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        new GUILogin();
    }
}
