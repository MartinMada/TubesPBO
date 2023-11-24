package model;

public class Person {
    private int id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String pic_path;

    public Person(int id, String password, String name, String email, String phone, String pic_path) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pic_path = pic_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }        

    public String getPic_Path() {
        return pic_path;
    }

    public void setpic_path(String pic_path) {
        this.pic_path = pic_path;
    } 
}
