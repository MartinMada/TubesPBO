/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    
    
    public GUIDetailBuku(){
        frame = new JFrame("Detail Buku");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        LineBorder lb = new LineBorder(Color.BLACK);
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), lb));

        imgicon1 = new JLabel(new ImageIcon(new ImageIcon("src\\image\\guts.jpg").getImage().getScaledInstance(400,800, Image.SCALE_DEFAULT)));
        imgicon1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")" + e);
            }
        });
        panel.add(imgicon1,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,30, 300, 300));
        
        
        frame.add(panel);
        frame.setVisible(true);
   } 
    public static void main(String[] args) {
        new GUIDetailBuku();
    }
 
}
