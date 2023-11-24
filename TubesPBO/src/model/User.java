package model;

import java.util.ArrayList;
import model.Enum.Genre;
public class User extends Person{
    private String bio;
    private ArrayList<Book> library;
    private int warning;

    public User(int id, String password, String name, String email, String phone, String picPath, String bio, ArrayList<Book> library, int warning) {
        super(id, password, name, email, phone, picPath);
        this.bio = bio;
        this.library = library;
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
