package model;

import java.time.LocalDateTime;

public class BookQueue {
    private int idUser;
    private LocalDateTime date;
    
    public BookQueue(int idUser, LocalDateTime date) {
        this.idUser = idUser;
        this.date = date;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }    
}
