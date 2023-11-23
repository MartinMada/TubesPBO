package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import model.Comment;
import model.User;

public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT WHERE BOOK TITLE
    public static Book getBook(String title) {
        conn.connect();
        String query = "SELECT * FROM book WHERE title='" + title;
        Book book = new Book();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // book.setIsbn(rs.getString("ISBN"));
                // book.setYear(rs.getLocalDateTime("Name"));
                book.setTitle(rs.getString("Title"));
                // book.setGenre(rs.getArray("Genre"));
                // book.setCategory(rs.get("Category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (book);
    }

    // SELECT ALL from table users
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM users";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setBio(rs.getString("Bio"));
                user.setWarning(rs.getInt("status_pelanggaran"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }

    // INSERT COMMENT
    public static boolean insertComment(Comment comment) {
        conn.connect();
        String query = "INSERT INTO comment VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setLong(1, comment.getIdComment());
            stmt.setLong(2, comment.getIdUser());
            // stmt.setString(3, comment.get());
            // stmt.setString(4, comment.getComment());
            // stmt.setLocalDate(5, comment.getDate());
            stmt.setString(6, comment.getContent());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // INSERT BUKU (ADMIN)
    public static boolean insertNewBook(Book book) {
        conn.connect();
        String query = "INSERT INTO book VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, book.getIsbn());
            // stmt.setArray(2, book.getGenre());
            stmt.setString(3, book.getTitle());
            stmt.setString(4, book.getAuthor());
            // stmt.setCategory(5, book.getCategory());
            // stmt.setLocalDateTime(6, book.getYear());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // UPDATE BOOK (ADMIN)
    public static boolean updateBook(Book book) {
        conn.connect();
        String query = "UPDATE book SET isbn='" + book.getIsbn() + "', "
                + "genre='" + book.getGenre() + "', "
                + "title='" + book.getTitle() + "' "
                + "author='" + book.getAuthor() + "' "
                + "category='" + book.getCategory() + "' "
                + "publication_year='" + book.getYear() + "' "
                + "WHERE isbn='" + book.getIsbn() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // DELETE BOOK (ADMIN)
    public static boolean deleteBook(String title) {
        conn.connect();

        String query = "DELETE FROM book WHERE title='" + title + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
