package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Enum.Category;
import model.Enum.Genre;

public class WishList extends Book{
    private LocalDate dateAdded;

    public WishList(String isbn, int year, String title, Genre genre, Category category,
            String author, int stock, String picPath, ArrayList<Review> review, ArrayList<BookQueue> queue, ArrayList<History> history,
            LocalDate dateAdded) {
        super(isbn, year, title, genre, category, author, stock, picPath, review, queue, history);
        this.dateAdded = dateAdded;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }    
}
