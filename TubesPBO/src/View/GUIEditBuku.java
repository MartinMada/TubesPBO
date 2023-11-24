/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author marti
 */
public class GUIEditBuku {
    private JFrame frame;
    private JPanel panel;
    private JLabel judul;
    private JLabel genre;
    private JLabel penulis;
    private JLabel kategori;
    private JLabel tahunTerbit;
    private JLabel sinopsis;
    private JTextField fieldJudul;
    private JTextField fieldGenre;
    private JTextField fieldPenulis;
    private JTextField fieldKategori;
    private JTextField fieldTterbit;
    private JTextArea fieldSinopsis;
    private JButton save;
    private JButton cancel;
    private String fetchJudul;
    private String fetchGenre;
    private String fetchPenulis;
    private String fetchKategori;
    private String fetchTterbit;
    private String fetchSinopsis;
    
    public GUIEditBuku(String isbn){
        frame = new JFrame("Edit Buku");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        judul = new JLabel("Judul");
        judul.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        
        fieldJudul = new JTextField();
        panel.add(fieldJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 300, 20));
        
        genre = new JLabel("Genre");
        genre.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(genre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        
        fieldGenre = new JTextField();
        panel.add(fieldGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 300, 20));
        
        penulis = new JLabel("Penulis");
        penulis.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(penulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        
        fieldPenulis = new JTextField();
        panel.add(fieldPenulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 300, 20));
        
        kategori = new JLabel("Kategori");
        kategori.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        
        fieldKategori = new JTextField();
        panel.add(fieldKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 300, 20));
        
        tahunTerbit = new JLabel("Tahun Terbit");
        tahunTerbit.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(tahunTerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        
        fieldTterbit = new JTextField();
        panel.add(fieldTterbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 200, 20));
        
        sinopsis = new JLabel("Sinopsis");
        sinopsis.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        panel.add(sinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        
        fieldSinopsis = new JTextArea();
        panel.add(fieldSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 300, 100));
        
        save = new JButton("Save");
        save.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               updateDataToDatabase(isbn);
               frame.dispose();
               new GUIDetailBukuAdmin(isbn, getImagePathFromDatabase(isbn));
            }
        });
        panel.add(save,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));
        
        cancel = new JButton("Cancel");
        cancel.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel.add(cancel,new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));
        
        frame.add(panel);
        frame.setVisible(true);
    }
    private void updateDataToDatabase(String isbn) {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "UPDATE book SET title=?, genre=?, author=?, category=?, year=?, sinopsis=? WHERE isbn=?";
            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                String newJudul = fieldJudul.getText();
                String newGenre = fieldGenre.getText();
                String newPenulis = fieldPenulis.getText();
                String newKategori = fieldKategori.getText();
                String newTterbit = fieldTterbit.getText();
                String newSinopsis = fieldSinopsis.getText();

                statement.setString(1, newJudul);
                statement.setString(2, newGenre);
                statement.setString(3, newPenulis);
                statement.setString(4, newKategori);
                statement.setString(5, newTterbit);
                statement.setString(6, newSinopsis);
                statement.setString(7, isbn);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

    public static void main(String[] args) {
        new GUIEditBuku("isbn");
    }
}
