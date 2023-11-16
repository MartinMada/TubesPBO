import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;

import Enum.Category;
import Enum.Genre;

public class BorrowedBook extends Book {
    LocalDate dateReturn;
    LocalDate dateBorrow;
    Timer timer;
    
    public BorrowedBook(String isbn, LocalDateTime year, String title, ArrayList<Genre> genre, Category category,
            String author, int stock, ArrayList<Review> review, ArrayList<BookQueue> queue, ArrayList<History> history,
            LocalDate dateReturn, LocalDate dateBorrow, Timer timer) {
        super(isbn, year, title, genre, category, author, stock, review, queue, history);
        this.dateReturn = dateReturn;
        this.dateBorrow = dateBorrow;
        this.timer = timer;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    public LocalDate getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDate dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }    
}
