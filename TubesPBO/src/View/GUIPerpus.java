/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marti
 */
public class GUIPerpus{
    private JFrame frame;
    private JPanel panel;
    
    public GUIPerpus(){
        frame = new JFrame("Perpustakaan");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
       new GUIPerpus();
        
    }
    
}
