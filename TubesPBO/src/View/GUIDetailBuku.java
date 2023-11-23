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
    
    
    
    
    public GUIDetailBuku(){
        frame = new JFrame("Detail Buku");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        LineBorder lb = new LineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), lb));

        imgicon1 = new JLabel(new ImageIcon(new ImageIcon("src\\image\\percyjackson.jpg").getImage().getScaledInstance(200,300, Image.SCALE_DEFAULT)));
//        imgicon1.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")" + e);
//            }
//        });
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
                new GUIReview();
            }
        });
        panel.add(ulasan,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        
        
        frame.add(panel);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
   } 
    public static void main(String[] args) {
        new GUIDetailBuku();
    }
 
}
