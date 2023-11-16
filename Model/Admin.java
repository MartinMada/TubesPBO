import java.util.ArrayList;

public class Admin extends Person{
    private ArrayList<Book> library;
    private ArrayList<Collection> collection;
    
    public Admin(long id, String password, String name, String email, String phone, ArrayList<Book> library,
            ArrayList<Collection> collection) {
        super(id, password, name, email, phone);
        this.library = library;
        this.collection = collection;
    }
    
    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Book> library) {
        this.library = library;
    }

    public ArrayList<Collection> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Collection> collection) {
        this.collection = collection;
    }

    // method dBook
    public void addBook(){

    }

    // method addCollection
    public void addCollection(){

    }
    
}
