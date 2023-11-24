/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marti
 */
public class GUIHomeGuest {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JTextField fieldBrowse;
    private JButton browsebtn;
    private JButton userProfile;
    private JLabel imgicon1;
    private JLabel imgicon2;
    private JLabel imgicon3;
    private JLabel labelCollection1;
    private JMenuBar menubar;
    private JMenu genre;
    private JMenu menuSignin;
    private JMenu menuRegister;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;
    private JMenuItem item6;
    private JMenuItem item7;

    
    public GUIHomeGuest(){
        frame = new JFrame("Home");
        frame.setSize(900,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("WELCOME");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(title,new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));
        
        fieldBrowse = new JTextField();
        panel.add(fieldBrowse,new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 400, 20));
        
        browsebtn = new JButton("Browse");
        browsebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel.add(browsebtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));
        
        labelCollection1 = new JLabel("Popular Now");
        labelCollection1.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelCollection1,new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 400, 20));
        
        imgicon1 = new JLabel(new ImageIcon(new ImageIcon("src\\gambar\\action\\The Spirit Glass.jpg").getImage().getScaledInstance(200,300, Image.SCALE_DEFAULT)));
        imgicon1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")" + e);
            }
        });
        panel.add(imgicon1,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,160, 300, 300));
        
        imgicon2 = new JLabel(new ImageIcon(new ImageIcon("src\\gambar\\comedy\\Spy×Family 12.jpg").getImage().getScaledInstance(200,300, Image.SCALE_DEFAULT)));
        imgicon2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")" + e);
            }
        });
        panel.add(imgicon2,new org.netbeans.lib.awtextra.AbsoluteConstraints(280,160, 300, 300));
        
        imgicon3 = new JLabel(new ImageIcon(new ImageIcon("src\\gambar\\fantasy\\Sword Catcher.jpg").getImage().getScaledInstance(200,300, Image.SCALE_DEFAULT)));
        imgicon3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")" + e);
            }
        });
        panel.add(imgicon3,new org.netbeans.lib.awtextra.AbsoluteConstraints(510,160, 300, 300));
        
        
        menubar = new JMenuBar();
        genre = new JMenu("GENRE");
        item1 = new JMenuItem("Action");
        item2 = new JMenuItem("Romance");
        item3 = new JMenuItem("Slice Of Life");
        item4 = new JMenuItem("Fantasy");
        item5 = new JMenuItem("SCI-FI");
        item6 = new JMenuItem("Horror");
        item7 = new JMenuItem("Comedy");
        genre.add(item1);
        genre.add(item2);
        genre.add(item3);
        genre.add(item4);
        genre.add(item5);
        genre.add(item6);
        genre.add(item7);
        
        menuSignin = new JMenu("Sign In");
        menuSignin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new GUILogin();
            }
        });
        
        menuRegister = new JMenu("Register");
        menuRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new GUIRegister();
            }
        });

        
        menubar.add(genre);
        menubar.add(menuSignin);
        menubar.add(menuRegister);
        
        userProfile = new JButton("Profile");
        userProfile.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        userProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIUserProfile();
            }
        });
        userProfile.setEnabled(false); // Jika belum menjadi user maka tidak bisa melihat profile
        panel.add(userProfile,new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 520, 200, 100));
        
        
        frame.add(panel);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new GUIHomeGuest();
    }
}