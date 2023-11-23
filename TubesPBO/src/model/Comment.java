package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comment {
    private long idComment;
    private long idUser;
    private String content;
    private LocalDate date;
    private ArrayList<Comment> comment;

    public Comment(){
    }

    public Comment(long idComment, long idUser, String content, LocalDate date, ArrayList<Comment> comment) {
        this.idComment = idComment;
        this.idUser = idUser;
        this.content = content;
        this.date = date;
        this.comment = comment;
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }                
}
