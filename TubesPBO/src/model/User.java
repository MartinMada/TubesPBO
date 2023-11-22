package model;

import java.util.ArrayList;
import model.Enum.Genre;
public class User extends Person{
    private String bio;
    private ArrayList<Book> library;
    private ArrayList<Genre> preferredGenre;
    private int warning;
    
    
    public User(long id, String password, String name, String email, String phone, String bio, ArrayList<Book> library,
            ArrayList<Genre> preferredGenre, int warning) {
        super(id, password, name, email, phone);
        this.bio = bio;
        this.library = library;
        this.preferredGenre = preferredGenre;
        this.warning = warning;
    }    

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Book> library) {
        this.library = library;
    }

    public ArrayList<Genre> getPreferredGenre() {
        return preferredGenre;
    }

    public void setPreferredGenre(ArrayList<Genre> preferredGenre) {
        this.preferredGenre = preferredGenre;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    // method add genre    
    public void addGenre(){

    }

    // method show library
    public void showLibrary(){

    }

    // method request add collection
    public void requestAddCollection(){

    }
}
