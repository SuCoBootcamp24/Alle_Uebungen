package example.administration.peoples;

import example.administration.Role;
import example.library.books.Book;

import java.util.ArrayList;

public abstract class People {

    private String name;

    private String email;

    private String address;

    private Role role;

    private final ArrayList<Book> BORROWED_LIST;

    public People(String name, String email, String address, Role role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.role = role;
        this.BORROWED_LIST = new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<Book> getBORROWED_LIST() {
        return BORROWED_LIST;
    }
}
