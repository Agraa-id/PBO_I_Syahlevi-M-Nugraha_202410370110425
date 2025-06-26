package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static ArrayList<User> userlist = new ArrayList<>();
    public static ArrayList<Item> reportedItem = new ArrayList<>();

    public static void main(String [] args){

        Admin admin1 = new Admin("Admin425", "425");
        Mahasiswa mahasiswa1 = new Mahasiswa("Agraa", "202410370110425");
        Scanner input = new Scanner(System.in);

        userlist.add(admin1);
        userlist.add(mahasiswa1);

        int login = 0;
        try {
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Pilih login(1/2): ");
            login = input.nextInt();
        } catch (InputMismatchException e) { // tipdat
            System.out.println("Input harus berupa angka!");
            input.nextLine(); // buang input error
        }


        if(login == 1){
            admin1.login();

        }else if(login == 2){
            mahasiswa1.login();
            mahasiswa1.displayInfo();
        }else {
            System.out.println("Data tidak Valid!");
        }




    }
}



