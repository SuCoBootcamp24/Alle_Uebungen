package example.administration.peoples;

import example.administration.Role;
import example.library.books.Book;

import java.util.ArrayList;

public class User extends People {


    public User(String name, String email, String address) {
        super(name, email, address, Role.USER);

    }

}
