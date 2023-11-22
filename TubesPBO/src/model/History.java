package model;

import java.time.LocalDate;

public class History {
    private long idUser;
    private LocalDate dateBorrow;
    private LocalDate dateReturn;

    public History(long idUser, LocalDate dateBorrow, LocalDate dateReturn) {
        this.idUser = idUser;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDate dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }            
}
