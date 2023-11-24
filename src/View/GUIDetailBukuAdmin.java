/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class GUIDetailBukuAdmin {
    private JFrame frame;
    private JPanel panel;
    private JLabel imgicon1;
    private JLabel labelJudul;
    private JLabel labelGenre;
    private JLabel labelPenulis;
    private JLabel labelTterbit;
    private JLabel labelKategori;
    private JLabel labelSinopsis;
    private JLabel ISBN;
    private JButton btnedit;
    private JButton btndelete;
    private JMenuBar menubar;
    private JMenu menu1;
    private JButton ulasan;
    public GUIDetailBukuAdmin(String ISBN,String pic_path){
        frame = new JFrame("Detail Buku");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        LineBorder lb = new LineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), lb));

        imgicon1 = new JLabel(new ImageIcon(new ImageIcon(getImagePathFromDatabase(ISBN)).getImage().getScaledInstance(200,300, Image.SCALE_DEFAULT)));
        panel.add(imgicon1,new org.netbeans.lib.awtextra.AbsoluteConstraints(20,20, 200,300));
        
        labelJudul = new JLabel("Judul");
        labelJudul.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        
        labelGenre = new JLabel("Genre");
        labelGenre.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));
        
        labelPenulis = new JLabel("Penulis");
        labelPenulis.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelPenulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));
        
        labelKategori = new JLabel("Kategori");
        labelKategori.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));
        
        labelTterbit = new JLabel("Tahun Terbit");
        labelTterbit.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelTterbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
        
        labelSinopsis = new JLabel("Sinopsis");
        labelSinopsis.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(labelSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));
        
        btnedit = new JButton("EDIT");
        btnedit.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIEditBuku(ISBN);
            }
        });
        panel.add(btnedit,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));
        
        btndelete = new JButton("DELETE");
        btndelete.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBookByISBN(ISBN);
            }
        });
        panel.add(btndelete,new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));
        
        menubar = new JMenuBar();
        menu1 = new JMenu();
        menu1.setText("Home");
        menu1.setMnemonic(KeyEvent.VK_A);
        menu1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new GUIAdmin();
            }
        });
        menubar.add(menu1);
        
        ulasan = new JButton("Lihat Ulasan");
        ulasan.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        ulasan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIReview();
            }
        });
        panel.add(ulasan,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        fetchDataFromDatabase(ISBN);
        
        frame.add(panel);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
   } 
    private void fetchDataFromDatabase(String isbn) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "SELECT * FROM book WHERE isbn = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, isbn);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Set the data to the labels or fields in the GUI
                        labelJudul.setText("Judul: " + resultSet.getString("title"));
                        labelGenre.setText("Genre: " + resultSet.getString("genre"));
                        labelPenulis.setText("Penulis: " + resultSet.getString("author"));
                        labelKategori.setText("Kategori: " + resultSet.getString("category"));
                        labelTterbit.setText("Tahun Terbit: " + resultSet.getString("year"));
                        labelSinopsis.setText("Sinopsis: " + resultSet.getString("sinopsis"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String getImagePathFromDatabase(String isbn) {
        String picPath = null;
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "SELECT pic_path FROM book WHERE isbn=?";
            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, isbn);
                try ( ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        picPath = resultSet.getString("pic_path");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return picPath;
    }
    private void deleteBookByISBN(String isbn) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String deleteQuery = "DELETE FROM book WHERE isbn=?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, isbn);
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Book with ISBN " + isbn + " deleted successfully.");
                } else {
                    System.out.println("Book with ISBN " + isbn + " not found.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new GUIDetailBukuAdmin("isbn","pic_path");
    }
 
}

