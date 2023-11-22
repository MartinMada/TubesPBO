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
    private JLabel labelJudulBuku;
    private JLabel labelISBN;
    private JLabel labelPenulis;
    private JLabel labelTahunTerbit;
    private JLabel labelGenre;
    private JTextField fieldISBN;
    private JTextField fieldJudul;
    private JTextField fieldPenulis;
    private JTextField fieldTahunTerbit;
    private JTextField fieldGenre;
    private JButton simpan;
    private JButton edit;
    private JButton hapus;
    private JTable listBuku;
    
    public GUIAdmin(){
        frame = new JFrame("Home Admin");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        title = new JLabel("Perpustakaan");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 20));
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));
        
        labelISBN = new JLabel("ISBN");
        labelISBN.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        
        fieldISBN = new JTextField();
        panel.add(fieldISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 300, 20));
        
        labelJudulBuku = new JLabel("Judul");
        labelJudulBuku.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelJudulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        
        fieldJudul = new JTextField();
        panel.add(fieldJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 300, 20));
        
        labelPenulis = new JLabel("Penulis");
        labelPenulis.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelPenulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        
        fieldPenulis = new JTextField();
        panel.add(fieldPenulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 300, 20));
        
        labelTahunTerbit = new JLabel("Tahun Terbit");
        labelTahunTerbit.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelTahunTerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
        
        fieldTahunTerbit = new JTextField();
        panel.add(fieldTahunTerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 300, 20));
        
        labelGenre = new JLabel("Genre");
        labelGenre.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));
        
        fieldGenre = new JTextField();
        panel.add(fieldGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 300, 20));
        
        simpan = new JButton("Save");
        simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(simpan,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));
        
        edit = new JButton("Edit");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(edit,new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400,-1, -1));
        
        hapus = new JButton("Delete");
        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(hapus,new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));
        
        listBuku = new JTable();

        listBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Title1", "Title2", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listBuku.setRowHeight(30);
        

        panel.add(listBuku,new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new GUIAdmin();
    }
}
