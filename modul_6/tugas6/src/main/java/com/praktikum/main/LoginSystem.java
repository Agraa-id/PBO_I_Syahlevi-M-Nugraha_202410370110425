package main.java.com.praktikum.main;

import main.java.com.praktikum.users.User;
import main.java.com.praktikum.data.DataStore;

public class LoginSystem {
    public static User login(String username, String password) {
        User user = DataStore.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}