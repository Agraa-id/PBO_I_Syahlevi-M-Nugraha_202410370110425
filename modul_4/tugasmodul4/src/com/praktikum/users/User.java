package com.praktikum.users;


public abstract class User {

    private String Name;    // 2 at
    private String Nim;

    public User(String Name, String Nim) {   // co
        this.Name = Name; 
        this.Nim = Nim;
    }

    public void setName(String name) { // nilai
        this.Name = name;

    }

    public String getName() { // akses
        return Name;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNim() {
        return Nim;
    }

    public abstract void login();
    public abstract void DisplayAppMenu();

    public abstract void reportedItems();

    public void displayInfo() {

        System.out.println("Informasi Pengguna: ");
        System.out.println("Nama: " + getName());
        System.out.println("Nim: " + getNim());



    }



}