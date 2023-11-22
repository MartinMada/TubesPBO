package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Review {
    private long idUser;
    private int rating;
    private LocalDate date;
    private String content;
    private ArrayList<Comment> comment;
    
    public Review(long idUser, int rating, LocalDate date, String content, ArrayList<Comment> comment) {
        this.idUser = idUser;
        this.rating = rating;
        this.date = date;
        this.content = content;
        this.comment = comment;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }        
}
