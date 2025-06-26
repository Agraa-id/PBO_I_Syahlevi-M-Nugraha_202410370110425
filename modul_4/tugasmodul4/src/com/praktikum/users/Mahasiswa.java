        package com.praktikum.users;

        import com.praktikum.main.Main;
        import com.praktikum.actions.MahasiswaActions;
        import com.praktikum.data.Item;

        import java.util.Iterator; //cara
        import java.util.Scanner;

        public class Mahasiswa extends User implements MahasiswaActions {
            String nama;
            String nim;
            public Mahasiswa(String nama, String nim){
                super(nama, nim);
                this.nama = nama;
                this.nim = nim;

            }

            @Override
            public void login(){
                Scanner input = new Scanner(System.in);
                System.out.print("Masukkan Nama Mahasiswa: ");
                String Nama = input.nextLine();
                System.out.print("Masukkan Nim Mahasiswa: ");
                String Nim = input.nextLine();

                boolean found = false;
                for (User user : Main.userlist){
                    if (user instanceof Mahasiswa){
                        Mahasiswa m = (Mahasiswa) user;
                        if (m.nama.equals(Nama) && m.nim.equals(Nim)){
                            found = true;
                            displayInfo();
                            DisplayAppMenu();
                            break;
                        }
                    }
                }
                if (!found){
                    System.out.println("Nama dan Pssword salah!");
                }
            }

            @Override
            public void DisplayAppMenu(){
                Scanner input = new Scanner(System.in);
                int pilih;
                System.out.println();
                System.out.println("======================================");
                System.out.println("|| Data Kehilangan Barang Mahasiswa ||");
                System.out.println("======================================");

                do{
                    System.out.println("Masukkan Pilihan: ");
                    System.out.println("1. Laporkan Barang Temuan/Hilang");
                    System.out.println("2. Lihat Daftar Laporan");
                    System.out.println("3. Logout");
                    System.out.print("Pilih(1-3): ");
                    pilih = input.nextInt();

                    System.out.println();

                    if (pilih == 1) {
                        reportItem();
                    } else if (pilih == 2) {
                        reportedItems();
                    } else if (pilih == 3) {
                        System.out.println(">> Terimakasih <<");
                    } else {
                        System.out.println("===================================");
                        System.out.println("|| Data yang Anda Masukkan Salah ||");
                        System.out.println("===================================");
                    }
                }while(pilih !=3);

            }


            @Override
            public void reportItem() {
                Scanner input = new Scanner(System.in);
                System.out.println("Nama barang: ");
                String nama = input.nextLine();
                System.out.println("Deskripsi: ");
                String deskripsi = input.nextLine();
                System.out.println("Lokasi: ");
                String lokasi = input.nextLine();

                Item item = new Item(nama, deskripsi, lokasi);
                Main.reportedItem.add(item);
                System.out.println(">> Barang berhasil dilaporkan!");
            }

            @Override
            public void viewReportItem(){
                Iterator<Item> it = Main.reportedItem.iterator();
                while (it.hasNext()) {
                    Item item = it.next();
                    if (item.getStatus().equals("Reported")) {
                        System.out.println("Nama: " + item.getItemName());
                        System.out.println("Deskripsi: " + item.getDescription());
                        System.out.println("Lokasi: " + item.getLocation());
                    }
                }

            }



            @Override
            public void reportedItems(){

                System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
            }

            @Override
            public void displayInfo(){
                System.out.println();
                System.out.println(">> Login Mahasiswa Berhasil <<");
                System.out.println(">> Informasi Pengguna <<");
                System.out.println("Nama: " + nama);
                System.out.println("Nim: " + nim);

            }
        }