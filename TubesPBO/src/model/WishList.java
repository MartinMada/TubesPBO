import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Enum.Category;
import Enum.Genre;

public class WishList extends Book{
    private LocalDate dateAdded;

    public WishList(String isbn, LocalDateTime year, String title, ArrayList<Genre> genre, Category category,
            String author, int stock, ArrayList<Review> review, ArrayList<BookQueue> queue, ArrayList<History> history,
            LocalDate dateAdded) {
        super(isbn, year, title, genre, category, author, stock, review, queue, history);
        this.dateAdded = dateAdded;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }    
}
