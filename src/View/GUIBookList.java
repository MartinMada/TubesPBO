/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIBookList extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private String selectedISBN;
    private String imagePath;

    public GUIBookList() {
        
        setTitle("Book List");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ISBN");
        tableModel.addColumn("Title");
        tableModel.addColumn("Author");
        tableModel.addColumn("Genre");
        tableModel.addColumn("Stock");

        fetchDataFromDatabase();

        table = new JTable(tableModel);
        table.setRowHeight(20, 10);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        selectedISBN = (String) table.getValueAt(selectedRow, 0);
                        imagePath = getImagePathFromDatabase(selectedISBN);
                        openDetailsFrame(selectedISBN);
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void fetchDataFromDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubespbo", "root", "")) {
            String query = "SELECT isbn, title, author, genre, stock FROM book";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String isbn = resultSet.getString("isbn");
                        String title = resultSet.getString("title");
                        String author = resultSet.getString("author");
                        String genre = resultSet.getString("genre");
                        int stock = resultSet.getInt("stock");

                        // Add data to the table model
                        Vector<Object> row = new Vector<>();
                        row.add(isbn);
                        row.add(title);
                        row.add(author);
                        row.add(genre);
                        row.add(stock);
                        tableModel.addRow(row);
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
    private void openDetailsFrame(String isbn) {
        dispose();
        new GUIDetailBukuAdmin(selectedISBN,imagePath);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIBookList());
    }
}

