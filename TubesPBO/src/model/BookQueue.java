import java.time.LocalDate;

public class BookQueue {
    private long idUser;
    private LocalDate date;
    
    public BookQueue(long idUser, LocalDate date) {
        this.idUser = idUser;
        this.date = date;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }    
}
