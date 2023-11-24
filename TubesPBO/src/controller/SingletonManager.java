/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import model.Person;

/**
 *
 * @author Darren
 */
public class SingletonManager {
    
    private static SingletonManager instance;
    private Person person;
//    SingletonManager.getInstance().setUser(new User());
    
    private SingletonManager() {
    }

    public static SingletonManager getInstance() {
        if (instance == null) {
            instance = new SingletonManager();
        }
        return instance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
