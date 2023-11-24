package model;

import java.time.LocalDateTime;

public class History {
    private int idUser;
    private LocalDateTime dateBorrow;
    private LocalDateTime dateReturn;

    public History(int idUser, LocalDateTime dateBorrow, LocalDateTime dateReturn) {
        this.idUser = idUser;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDateTime dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDateTime getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDateTime dateReturn) {
        this.dateReturn = dateReturn;
    }            
}
