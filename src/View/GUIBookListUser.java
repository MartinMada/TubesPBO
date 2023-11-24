/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author marti
 */
import controller.BookController;
import controller.SingletonManager;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import model.Book;
import model.Enum.SearchType;
import model.User;

public class GUIBookListUser extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private String selectedISBN;
    private String imagePath;

    public GUIBookListUser(ArrayList<Book> books) {
        setTitle("Book List");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ISBN");
        tableModel.addColumn("Title");
        tableModel.addColumn("Author");
        tableModel.addColumn("Genre");
        tableModel.addColumn("Stock");
        
        displayBooks(books);
        
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

    public void displayBooks(ArrayList<Book> books) {
        for (Book book : books) {
            Vector<Object> row = new Vector<>();
            row.add(book.getIsbn());
            row.add(book.getTitle());
            row.add(book.getAuthor());
            row.add(book.getGenre());
            row.add(book.getStock());
            tableModel.addRow(row);
        }
    }
    
    public String getImagePathFromDatabase(String isbn) {
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
        new GUIDetailBuku(selectedISBN,imagePath);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookController bc = new BookController();
            User loggedInUser = (User) SingletonManager.getInstance().getPerson();
            ArrayList<Book> searchResults = bc.searchBook(SearchType.GENRE, "Action", loggedInUser);

            new GUIBookListUser(searchResults);
        });
    }
}

