import java.time.LocalDateTime;
import java.util.ArrayList;
import Enum.Category;
import Enum.Genre;

public class Book {
    private String isbn;
    private LocalDateTime year;
    private String title;
    private ArrayList<Genre> genre;
    private Category category;
    private String author;
    private int stock;
    private ArrayList<Review> review;
    private ArrayList<BookQueue> queue;
    private ArrayList<History> history;
    
    public Book(String isbn, LocalDateTime year, String title, ArrayList<Genre> genre, Category category, String author,
            int stock, ArrayList<Review> review, ArrayList<BookQueue> queue, ArrayList<History> history) {
        this.isbn = isbn;
        this.year = year;
        this.title = title;
        this.genre = genre;
        this.category = category;
        this.author = author;
        this.stock = stock;
        this.review = review;
        this.queue = queue;
        this.history = history;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }

    public ArrayList<BookQueue> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<BookQueue> queue) {
        this.queue = queue;
    }

    public ArrayList<History> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<History> history) {
        this.history = history;
    }         
}
