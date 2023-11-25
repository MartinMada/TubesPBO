/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import controller.Access;
import controller.SingletonManager;
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
import model.Admin;
import model.User;

/**
 *
 * @author marti
 */
public class GUILogin {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JTextField fieldName;
    private JPasswordField fieldPass;
    private JLabel labelEmail;
    private JLabel labelPass;
    private JButton loginbtn;
    private JButton backbtn;
    
    
    public GUILogin(){
        Access a = new Access();
        frame = new JFrame("Login");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("Login");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(title,new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        
        labelEmail = new JLabel("Username");
        labelEmail.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelEmail,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));
        
        fieldName = new JTextField();
        panel.add(fieldName,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 300, 20));
        
        labelPass = new JLabel("Password");
        labelPass.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelPass,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        
        fieldPass = new JPasswordField();
        panel.add(fieldPass,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 300, 20));
        
        loginbtn = new JButton("Login");
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fieldName.getText();
                String password = new String(fieldPass.getPassword());
                a.login(name,password);

        //      a.logoff();
                if (SingletonManager.getInstance().getPerson() instanceof User) {
                    JOptionPane.showMessageDialog(null,"Selamat Datang " + name,"Info",JOptionPane.INFORMATION_MESSAGE);
//                    System.out.println(((User) (SingletonManager.getInstance().getPerson())).getBio());
//                    System.out.println(((User) (SingletonManager.getInstance().getPerson())).getWarning());
                    frame.dispose();
                    new GUIHomeUser();
                } else if (SingletonManager.getInstance().getPerson() instanceof Admin) {
                    JOptionPane.showMessageDialog(null,"Selamat Datang ADMIN " + name,"Info",JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new GUIAdmin();
                } else {
                    JOptionPane.showMessageDialog(null,"INVALID USER/ADMIN","WARNING",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        backbtn = new JButton("Back");
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIHomeGuest();
            }
        });
        panel.add(loginbtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));
        panel.add(backbtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        new GUILogin();
    }
}
