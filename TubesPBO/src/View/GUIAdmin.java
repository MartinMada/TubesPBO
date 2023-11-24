/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author marti
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class GUIAdmin {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JLabel titleMainMenu;
    private JButton lihatBuku;
    private JButton lihatUser;
    
    
    public GUIAdmin(){
        frame = new JFrame("Home Admin");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("Admin Perpustakaan");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 20));
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
        
        titleMainMenu = new JLabel("Main Menu");
        titleMainMenu.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(titleMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));
        
        lihatBuku = new JButton("VIEW BOOKS");
        lihatBuku.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        lihatBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIBookList();
            }
        });
        panel.add(lihatBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 140, 200, 50));
        
        lihatUser = new JButton("VIEW USER");
        lihatUser.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        lihatUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(lihatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 220, 200, 50));
        
        
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new GUIAdmin();
    }
}
