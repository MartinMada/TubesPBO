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
    private JButton addBook;
    private JButton editBook;
    private JButton deleteBook;
//    private JTextField fieldISBN;
//    private JTextField fieldJudul;
//    private JTextField fieldPenulis;
//    private JTextField fieldTahunTerbit;
//    private JTextField fieldGenre;
    private JButton simpan;
    
    public GUIAdmin(){
        frame = new JFrame("Home Admin");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("Admin Perpustakaan");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 20));
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));
        
        titleMainMenu = new JLabel("Main Menu");
        titleMainMenu.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(titleMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));
        
        addBook = new JButton("Tambah Buku");
        addBook.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(addBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));
        
        editBook = new JButton("Edit Buku");
        editBook.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(editBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));
        
        deleteBook = new JButton("Hapus Buku");
        deleteBook.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(deleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 260, -1, -1));
        
        lihatUser = new JButton("Lihat User");
        lihatUser.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(lihatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 320, -1, -1));
        
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new GUIAdmin();
    }
}
