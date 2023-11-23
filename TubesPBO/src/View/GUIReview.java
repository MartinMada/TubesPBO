/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author marti
 */
public class GUIReview {
    private JFrame frame;
    private JPanel panel;
    private JLabel labelComment;
    private JTextArea fieldComment;
    private JButton replybtn;
    private JTextArea fieldReply;
    private JButton submit;
    private int count = 0;
    
    
    public GUIReview(){
        frame = new JFrame("Review");
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        labelComment = new JLabel("Comments: " + "(" + count + ")");
        labelComment.setFont(new java.awt.Font("Bookman Old Style", 1, 22));
        panel.add(labelComment,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,30, -1, -1));
        
        fieldComment = new JTextArea();
        panel.add(fieldComment,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,80, 400,50));
        
        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fieldComment.getText().isEmpty()){
                    count++;
                    labelComment.setText("Comments: " + "(" + count + ")");
                    fieldComment.setText(null);
                }else{
                    JOptionPane.showMessageDialog(null,"Ketik sesuatu","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel.add(submit,new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        new GUIReview();
    }
}
