/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import controller.BookController;
import controller.SingletonManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Book;
import model.User;

/**
 *
 * @author marti
 */
public class GUIDetailBuku {
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
    private JButton btnpinjam;
    private JButton btnantri;
    private JMenuBar menubar;
    private JMenu menu1;
    private JButton ulasan;
    BookController bc = new BookController();
    public GUIDetailBuku(String ISBN,String pic_path){
        
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
        
        btnpinjam = new JButton("PINJAM");
        btnpinjam.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        btnpinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book booktmp = bc.searchBook(ISBN);
//                System.out.println(ISBN);
//                System.out.println(booktmp.getTitle());
                boolean pinjamBuku = bc.borrowBook(booktmp, (User) SingletonManager.getInstance().getPerson());
                if (pinjamBuku) {
                     JOptionPane.showMessageDialog(null,"BERHASIL MEMINJAM BUKU!","INFO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                     JOptionPane.showMessageDialog(null,"GAGAL MEMINJAM BUKU!","INFO",JOptionPane.WARNING_MESSAGE);
                }
//                System.out.println("BERHASIL");
            
            }
        });
        panel.add(btnpinjam,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));
        
        
        btnantri = new JButton("ANTRI");
        btnantri.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        btnantri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
        });
        panel.add(btnantri,new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));
        
        Book ableToBorrowBook = bc.searchBook(ISBN);
        if (bc.ableToBorrow(ableToBorrowBook, (User) SingletonManager.getInstance().getPerson())) {
            btnpinjam.setVisible(true);
            btnantri.setVisible(false);
        }else{
            btnantri.setVisible(true);
            btnpinjam.setVisible(false);
        }
        
        
        menubar = new JMenuBar();
        menu1 = new JMenu();
        menu1.setText("Home");
        menu1.setMnemonic(KeyEvent.VK_A);
        menu1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new GUIHomeUser();
            }
        });
        menubar.add(menu1);
        
        ulasan = new JButton("Lihat Ulasan");
        ulasan.setFont(new java.awt.Font("Bookman Old Style", 1, 16));
        ulasan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIReview(ISBN);
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

    public static void main(String[] args) {
        new GUIDetailBuku("isbn","pic_path");
    }
 
}
