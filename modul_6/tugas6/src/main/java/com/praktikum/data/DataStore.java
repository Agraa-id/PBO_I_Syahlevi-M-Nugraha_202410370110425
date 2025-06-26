package main.java.com.praktikum.data;

import main.java.com.praktikum.users.*;
import java.util.*;

public class DataStore {
    public static HashMap<String, User> userDB = new HashMap<>();

    static {
        userDB.put("admin", new Admin("admin", "admin123"));
        userDB.put("mhs1", new Mahasiswa("mhs1", "123", "Syahlevi Nugraha", "202410370110425", "Informatika"));
    }

    public static User getUser(String username) {
        return userDB.get(username);
    }

    public static Collection<User> getAllUsers() {
        return userDB.values();
    }
}
