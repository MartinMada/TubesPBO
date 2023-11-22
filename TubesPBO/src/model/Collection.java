package model;

import java.util.ArrayList;
import Enum.CollectionStatus;
import java.time.LocalDate;

public class Collection {
    private String name;
    private ArrayList<Book> book;
    private CollectionStatus collectionStatus;
    private LocalDate localDate;
    private long idCreator;
    private long idAdmin;
    
    public Collection(String name, ArrayList<Book> book, CollectionStatus collectionStatus, LocalDate localDate,
            long idCreator, long idAdmin) {
        this.name = name;
        this.book = book;
        this.collectionStatus = collectionStatus;
        this.localDate = localDate;
        this.idCreator = idCreator;
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBook() {
        return book;
    }

    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }

    public CollectionStatus getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(CollectionStatus collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public long getidCreator() {
        return idCreator;
    }

    public void setidCreator(long idCreator) {
        this.idCreator = idCreator;
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    // method change collection status
    public void changeCollectionStatus(){

    }
    
}
