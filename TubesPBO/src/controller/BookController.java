/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Admin;
import model.Book;
import model.BorrowedBook;
import model.Enum.Category;
import model.Enum.Genre;
import model.Enum.SearchType;
import model.Person;
import model.User;

/**
 *
 * @author Darren
 */
public class BookController {
    public ArrayList<Book> searchBook(SearchType type, String search, User user){
        DatabaseHandler.getInstance().connect();
        ArrayList<Book> result = new ArrayList<>();
        String searchType = type.toString().toLowerCase();
        
        String query = "SELECT * FROM book WHERE " + searchType + "='" + search + "'";
        if(user != null) {
            query += " AND isbn NOT IN (SELECT isbn FROM listborrow WHERE id_user=" + user.getId() + " AND TIMESTAMPDIFF(SECOND, date_borrow, NOW())<432000)";
        }
        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Genre genreTmp = Genre.ACTION;
                for(Genre genreLoop : Genre.values()) {
                    if(genreLoop.toString().equals(rs.getString("genre"))) {
                        genreTmp = genreLoop;
                    }
                }
                
                Category categoryTmp = Category.FICTION;
                for(Category categoryLoop : Category.values()) {
                    if(categoryLoop.toString().equals(rs.getString("category"))) {
                        categoryTmp = categoryLoop;
                    }
                }
                result.add(new Book(rs.getString("isbn"), rs.getInt("year"), rs.getString("title"), genreTmp, categoryTmp, rs.getString("author"), rs.getInt("stock"), rs.getString("pic_path"), null, null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Book searchBook(String isbn){
        DatabaseHandler.getInstance().connect();
        Book result = null;
        
        String query = "SELECT * FROM book WHERE isbn='" + isbn + "';";

        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Genre genreTmp = Genre.ACTION;
                for(Genre genreLoop : Genre.values()) {
                    if(genreLoop.toString().equals(rs.getString("genre"))) {
                        genreTmp = genreLoop;
                    }
                }
                
                Category categoryTmp = Category.FICTION;
                for(Category categoryLoop : Category.values()) {
                    if(categoryLoop.toString().equals(rs.getString("category"))) {
                        categoryTmp = categoryLoop;
                    }
                }
                result = new Book(rs.getString("isbn"), rs.getInt("year"), rs.getString("title"), genreTmp, categoryTmp, rs.getString("author"), rs.getInt("stock"), rs.getString("pic_path"), null, null, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<Book> getListBorrow (User user) {
        updateListBorrow();
        DatabaseHandler.getInstance().connect();
        ArrayList<Book> result = new ArrayList<>();
        String querySelect = "SELECT lb.id_list_borrow, lb.isbn, (SELECT year FROM book WHERE isbn = lb.isbn) AS book_year, (SELECT title FROM book WHERE isbn = lb.isbn) AS book_title, (SELECT genre FROM book WHERE isbn = lb.isbn) AS book_genre, (SELECT category FROM book WHERE isbn = lb.isbn) AS book_category, (SELECT author FROM book WHERE isbn = lb.isbn) AS book_author, (SELECT stock FROM book WHERE isbn = lb.isbn) AS book_stock, (SELECT pic_path FROM book WHERE isbn = lb.isbn) AS book_pic_path, lb.date_borrow, lb.date_return FROM listborrow lb WHERE lb.id_user='" + user.getId() + "' AND TIMESTAMPDIFF(SECOND, lb.date_borrow, NOW())<432000)";
    
        try {
            
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rs = stmt.executeQuery(querySelect);
            while (rs.next()) {
                Genre genreTmp = Genre.ACTION;
                for(Genre genreLoop : Genre.values()) {
                    if(genreLoop.toString().equals(rs.getString("book_genre"))) {
                        genreTmp = genreLoop;
                    }
                }
                
                Category categoryTmp = Category.FICTION;
                for(Category categoryLoop : Category.values()) {
                    if(categoryLoop.toString().equals(rs.getString("book_category"))) {
                        categoryTmp = categoryLoop;
                    }
                }
                result.add(new BorrowedBook(rs.getInt("id_list_borrow"), rs.getString("isbn"), rs.getInt("book_year"), rs.getString("book_title"), genreTmp, categoryTmp, rs.getString("book_author"), rs.getInt("book_stock"), rs.getString("book_pic_path"), null, null, null, rs.getTimestamp("date_return").toLocalDateTime(), rs.getTimestamp("date_borrow").toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void updateListBorrow () {
        DatabaseHandler.getInstance().connect();
        String querySelect = "SELECT id_list_borrow, isbn FROM listborrow WHERE TIMESTAMPDIFF(SECOND, date_borrow, NOW())>=432000 AND date_return = NULL;";
        
        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rsSelect = stmt.executeQuery(querySelect);
            while(rsSelect.next()) {
                String queryUpdate = "UPDATE listborrow SET date_return = TIMESTAMPADD(DAY, 5, date_borrow) WHERE id_list_borrow = " + rsSelect.getInt("id_list_borrow") + "; CALL updateListBorrow('" + rsSelect.getString("isbn") + "');";
                Statement stmt2 = DatabaseHandler.getInstance().con.createStatement();
                stmt2.executeQuery(queryUpdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public boolean ableToBorrow(Book book) {
        updateListBorrow();
        DatabaseHandler.getInstance().connect();
        String querySelect = "SELECT COUNT(id_list_borrow) AS result FROM listborrow WHERE isbn='"+ book.getIsbn() +"' TIMESTAMPDIFF(SECOND, date_borrow, NOW())<432000 AND date_return = NULL;";
        
        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rsSelect = stmt.executeQuery(querySelect);
            
            while(rsSelect.next()) {
                if(rsSelect.getInt("result")< book.getStock()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean returnBook (BorrowedBook borrowedBook) {
        DatabaseHandler.getInstance().connect();
        String querySelect = "SELECT id_list_borrow, isbn FROM listborrow WHERE id_list_borrow = " + borrowedBook.getIdListBorrow() + ";";
        
        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rsSelect = stmt.executeQuery(querySelect);
            while(rsSelect.next()) {
                String queryUpdate = "UPDATE listborrow SET date_return = NOW() WHERE id_list_borrow = " + rsSelect.getInt("id_list_borrow") + "; CALL updateListBorrow('" + rsSelect.getString("isbn") + "');";
                Statement stmt2 = DatabaseHandler.getInstance().con.createStatement();
                stmt2.executeQuery(queryUpdate);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public boolean borrowBook (Book book, User user) {
        if (!ableToBorrow(book)) {return false;}
        DatabaseHandler.getInstance().connect();
        String query = "INSERT INTO listborrow (isbn, id_user, date_borrow) VALUES(?,?,?)";
        try {
            PreparedStatement stmt =  DatabaseHandler.getInstance().con.prepareStatement(query);
            stmt.setString(1, book.getIsbn());
            stmt.setInt(2, user.getId());
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();

            return (true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return (false);
        }
    }
    
    public boolean addBookQueue (Book book, User user) {
        if (ableToBorrow(book)) {return false;}
        DatabaseHandler.getInstance().connect();
        String query = "INSERT INTO bookqueue (isbn, id_user, date_borrow) VALUES(?,?,?)";
        try {
            PreparedStatement stmt =  DatabaseHandler.getInstance().con.prepareStatement(query);
            stmt.setString(1, book.getIsbn());
            stmt.setInt(2, user.getId());
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
            return (true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return (false);
        }
    }
    
}