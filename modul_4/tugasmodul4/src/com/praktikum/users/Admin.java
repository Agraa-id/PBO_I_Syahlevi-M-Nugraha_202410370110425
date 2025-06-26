package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    String username;
    String password;  // co dt log
    Scanner input = new Scanner(System.in); // obj scan

    public Admin(String username, String password){ // co
        super(username, password); // spr cl
        this.username = username; // bd par dan at
        this.password = password;
    }

    @Override
    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Username: ");
        String Username = input.nextLine();
        System.out.print("Masukkan Password: ");
        String Password = input.nextLine();

        boolean found = false;
        for (User user : Main.userlist){
            if(user instanceof Admin){
                Admin adm = (Admin) user;
                if (adm.username.equals(Username) && adm.password.equals(Password)){
                    found = true;
                    displayInfo();
                    DisplayAppMenu();
                    break;
                }
            }
        }
        if (!found){
            System.out.println("Username dan Password salah!");
        }
    }


    @Override
    public void DisplayAppMenu(){
        Scanner input = new Scanner(System.in);
        int pilih;

        do{
            System.out.println("Masukkan Pilihan: ");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilih(1-3): ");
            pilih = input.nextInt();



            if (pilih == 1) {
                manageItem();
            } else if (pilih == 2) {
                manageUsers();
            } else if (pilih == 3) {
                System.out.println(">> Terimakasih <<");
            } else {
                System.out.println(">> Data yang Anda Masukkan Salah <<");
            }
        }while(pilih !=0);

    }

    @Override
    public void reportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }


    @Override
    public void manageItem(){
       Scanner input  = new Scanner(System.in);

       while (true){
           System.out.println("1. Lihat semua laporan");
           System.out.println("2. Tandai barang telah diambil");
           System.out.println("3. Kembali");
           int pilih = 0;
           try {
               System.out.print("Pilih: ");
               pilih = input.nextInt();
               input.nextLine(); // bersihkan buffer
           } catch (InputMismatchException e) {
               System.out.println(">> Input harus berupa angka!");
               input.nextLine(); // reset buffer
           }


           switch (pilih){
               case 1:
                   for (int i = 0; i < Main.reportedItem.size(); i++){
                       Item item = Main.reportedItem.get(i);
                       System.out.println(i + " . " + item.getItemName() + " - " + item.getStatus());
                   }
                   break;
               case 2:
                   try {
                       System.out.print("Masukkan indeks barang: ");
                       int index = input.nextInt();
                       input.nextLine(); // buffer
                       Main.reportedItem.get(index).setStatus("Claimed");
                       System.out.println("Status berhasil diubah!");
                   } catch (InputMismatchException e) {
                       System.out.println(">> Input harus berupa angka!");
                       input.nextLine(); // buang input error
                   } catch (IndexOutOfBoundsException e) { //indx tdk valid
                       System.out.println(">> Indeks tidak ditemukan!");
                   }

                   break;
               case 3:
                   return;
               default:
                   System.out.println(">> pilihan tidak valid");
           }
       }
    }

    @Override
    public void manageUsers(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) {
            System.out.print("Nama Mahasiswa: ");
            String nama = input.nextLine();
            System.out.print("NIM Mahasiswa: ");
            String nim = input.nextLine();
            Mahasiswa mhs = new Mahasiswa(nama, nim);
            Main.userlist.add(mhs);
            System.out.println("Mahasiswa berhasil ditambahkan.");
        } else if (pilih == 2) {
            System.out.print("Masukkan NIM yang akan dihapus: ");
            String nim = input.nextLine();
            boolean removed = Main.userlist.removeIf(user -> user instanceof Mahasiswa && ((Mahasiswa) user).nim.equals(nim));
            if (removed) {
                System.out.println("Mahasiswa berhasil dihapus.");
            } else {
                System.out.println("Mahasiswa tidak ditemukan.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    @Override
    public void displayInfo(){
        System.out.println("Login Admin Berhasil!");
    }
}