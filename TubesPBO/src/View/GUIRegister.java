/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import Controller.Controller;
import Controller.DatabaseHandler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;
import model.Person;


public class GUIRegister {
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menubar;
    private JMenu menu1;
    private JMenu menu2;
    private JLabel title;
    private JLabel labelName;
    private JLabel labelPass;
    private JLabel labelEmail;
    private JLabel labelPhone;
    private JTextField fieldName;
    private JPasswordField fieldPass;
    private JTextField fieldEmail;
    private JTextField fieldPhone;
    private JButton registerbtn;
    private JButton fotobtn;
    private JLabel foto;
    private String pathFoto;
    private JFileChooser pilihFoto;
    private ImageIcon fotoIcon;
    private Image fotoImg;
    
    static DatabaseHandler conn = new DatabaseHandler();
    
    public GUIRegister(){
        Controller cntrl = new Controller();
        frame = new JFrame("Guest");
        frame.setSize(550, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        menubar = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu1.setText("Home");
        menu1.setMnemonic(KeyEvent.VK_A);
        menu1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new GUIHomeGuest();
            }
        });

        menu2.setText("Sign In");
        menu2.setMnemonic(KeyEvent.VK_A);
        menu2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new GUILogin();
            }
        });
        
        menubar.add(menu1);
        menubar.add(menu2);
        
        title = new JLabel("REGISTER NOW");
        title.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        
        labelName = new JLabel("Nama");
        labelName.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelName,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,80, -1, -1));
        
        fieldName = new JTextField();
        panel.add(fieldName,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,100, 350, 20));
        
        labelPass = new JLabel("Password");
        labelPass.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelPass,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,130, -1, -1));
        
        fieldPass = new JPasswordField();
        panel.add(fieldPass,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,150, 350, 20));
        
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelEmail,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,180, -1, -1));
        
        fieldEmail = new JTextField();
        panel.add(fieldEmail,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,200, 350, 20));
        
        labelPhone = new JLabel("No.Telp");
        labelPhone.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(labelPhone,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,230, -1, -1));
        
        fieldPhone = new JTextField();
        panel.add(fieldPhone,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,250, 350, 20));
        
        foto = new JLabel("Pilih Foto");
        foto.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(foto,new org.netbeans.lib.awtextra.AbsoluteConstraints(50,280, 350, 20));
        
        fotobtn = new JButton("Choose a file!");
        fotobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooser();
            }
        });
        panel.add(fotobtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));
        
        registerbtn = new JButton("Submit");
        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel.add(registerbtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));
        
//        fieldName.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                // Metode ini dipanggil ketika sebuah karakter diketik (termasuk karakter spasi)
//                System.out.println("Key Typed: " + e.getKeyChar());
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                // Metode ini dipanggil ketika sebuah tombol ditekan
////                System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                // Metode ini dipanggil ketika sebuah tombol dilepas
////                System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
//            }
//        });
        frame.add(panel);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
    }
    public void showFileChooser() {
        pilihFoto = new JFileChooser();
        pilihFoto.setDialogTitle("Choose a file");

        int result = pilihFoto.showOpenDialog(panel);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(panel, "File yang dipilih: " + pilihFoto.getSelectedFile().getAbsolutePath());
            pathFoto = pilihFoto.getSelectedFile().getAbsolutePath();
            fotoIcon = new ImageIcon(pathFoto);
            fotoImg = fotoIcon.getImage();
            Image fotoRes = fotoImg.getScaledInstance(100,100 , Image.SCALE_SMOOTH);
            ImageIcon newFotoRes = new ImageIcon(fotoRes);

            JLabel labelFoto = new JLabel();
            labelFoto.setIcon(newFotoRes);
            panel.add(labelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140,610, 100));
            panel.revalidate();
            panel.repaint();
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(panel, "Pemilihan file dibatalkan");
        }
    }
    public boolean registerConfirm(Component... components){
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if (textField.getText().trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
        
        
    public static void main(String[] args) {
        new GUIRegister();
    }
}
