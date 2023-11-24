/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Access;
import model.Person;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUIUserProfile {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JLabel nama;
    private JLabel email;
    private JLabel notelp;
    private JLabel pass;
    private JTextField fieldNama;
    private JTextField fieldEmail;
    private JTextField fieldNotelp;
    private JPasswordField fieldPassword;
    private JButton btnedit;
    private JButton save;
    private JButton back;
    
    
    public GUIUserProfile(){
        Access cntrl = new Access();
        frame = new JFrame("User Profile");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("Profile");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 24));
        panel.add(title,new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        
        nama = new JLabel("Nama:");
        nama.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(nama,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        
        fieldNama = new JTextField("Your Name");
        fieldNama.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(fieldNama,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 300, 20));
        fieldNama.setEnabled(false);
        
        email = new JLabel("Email:");
        email.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(email,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        
        fieldEmail = new JTextField("Your Email");
        fieldEmail.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(fieldEmail,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 300, 20));
        fieldEmail.setEnabled(false);
        
        notelp = new JLabel("No.Telp:");
        notelp.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(notelp,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        
        fieldNotelp = new JTextField("Your Phone");
        fieldNotelp.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(fieldNotelp,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 300, 20));
        fieldNotelp.setEnabled(false);
        
        pass = new JLabel("Password:");
        pass.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(pass,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        
        fieldPassword = new JPasswordField("pass");
        panel.add(fieldPassword,new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 300, 20));
        fieldPassword.setEnabled(false);
        
        btnedit = new JButton("Edit Profile");
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save.setEnabled(true);
                back.setEnabled(false);
                fieldNama.setEnabled(true);
                fieldEmail.setEnabled(true);
                fieldNotelp.setEnabled(true);
                fieldPassword.setEnabled(true);
            }
        });
        panel.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back.setEnabled(true);
                fieldNama.setEnabled(false);
                fieldEmail.setEnabled(false);
                fieldNotelp.setEnabled(false);
                fieldPassword.setEnabled(false);
                save.setEnabled(false);
                //Update data ke database
            }
        });
        save.setEnabled(false);
        panel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        back = new JButton("Kembali");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIHomeUser();
            }
        });
        panel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));

        frame.add(panel);
        frame.setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        new GUIUserProfile();
    }
}
