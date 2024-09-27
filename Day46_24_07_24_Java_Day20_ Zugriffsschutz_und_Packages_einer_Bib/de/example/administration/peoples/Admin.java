package example.administration.peoples;

import example.administration.Role;

public class Admin extends People {


    public Admin(String name, String email, String address) {
        super(name, email, address, Role.ADMIN);
    }


}
