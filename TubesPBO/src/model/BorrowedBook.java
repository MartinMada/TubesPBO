package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;

import model.Enum.Category;
import model.Enum.Genre;

public class BorrowedBook extends Book {
    int idListBorrow;
    LocalDateTime dateReturn;
    LocalDateTime dateBorrow;
    
    public BorrowedBook(int idListBorrow, String isbn, int year, String title, Genre genre, Category category,
            String author, int stock, String picPath, ArrayList<Review> review, ArrayList<BookQueue> queue, ArrayList<History> history,
            LocalDateTime dateReturn, LocalDateTime dateBorrow) {
        super(isbn, year, title, genre, category, author, stock, picPath, review, queue, history);
        this.idListBorrow = idListBorrow;
        this.dateReturn = dateReturn;
        this.dateBorrow = dateBorrow;

    }

    public int getIdListBorrow() {
        return idListBorrow;
    }

    public LocalDateTime getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDateTime dateReturn) {
        this.dateReturn = dateReturn;
    }

    public LocalDateTime getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDateTime dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

}
