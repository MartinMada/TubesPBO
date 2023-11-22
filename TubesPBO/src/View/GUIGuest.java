/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class GUIGuest {
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menubar;
    private JMenu menu1;
    private JLabel title;
    private JLabel labelName;
    private JLabel labelPass;
    private JLabel labelEmail;
    private JLabel labelPhone;
    private JTextField fieldName;
    private JTextField fieldPass;
    private JTextField fieldEmail;
    private JTextField fieldPhone;
    private JButton registerbtn;
    
    public GUIGuest(){
        frame = new JFrame("Guest");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        menubar = new JMenuBar();
        menu1 = new JMenu();
        menu1.setText("Home");
        menu1.setMnemonic(KeyEvent.VK_A);
        menu1.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menubar.add(menu1);
        
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
        
        fieldPass = new JTextField();
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
        
        registerbtn = new JButton("Submit");
        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = registerConfirm(fieldName,fieldPass,fieldEmail,fieldPhone);
                if (isValid) {
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"Berhasil","Info",JOptionPane.INFORMATION_MESSAGE);
                    //insert database
                }else{
                    JOptionPane.showMessageDialog(null,"Silahkan isi semua data!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(registerbtn,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        
        frame.add(panel);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
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
        new GUIGuest();
    }
    
}
