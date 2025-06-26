package Main;
import Barang.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args){
        int pilih;
        Scanner sc = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("Pensil",5));
        daftarBarang.add(new Barang("Buku",10));

        do {
            System.out.println("===== Menu Utama ======");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1/2/3/4) : ");
            pilih = sc.nextInt();

            if (pilih == 1) {
                try {
                    System.out.print("Masukkan Nama Barang : ");
                    sc.nextLine();
                    String namabaru = sc.nextLine();
                    System.out.print("Masukkan Stok Barang : ");
                    int stokbarang = sc.nextInt();
                    sc.nextLine();

                    Barang tambahan = new Barang(namabaru, stokbarang);
                    daftarBarang.add(tambahan);
                    System.out.println("Barang " + namabaru + " berhasil ditambahkan.");

                } catch (InputMismatchException e) {
                    System.out.println("Error : Input stok harus berupa angka!");
                    sc.nextLine();
                }

            } else if (pilih == 2) {
                System.out.println("Daftar Barang");
                for (Barang barang1 : daftarBarang) {
                    System.out.println("Nama Barang: " + barang1.getNama() + "\nStok Barang: " + barang1.getStok());
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang");
                    }
                }

            } else if (pilih == 3) {
                for (int i = 0; i < daftarBarang.size(); i++) {
                    System.out.println((i) + ". Nama Barang : " + daftarBarang.get(i).getNama() +
                            "\n   Stok Barang : " + daftarBarang.get(i).getStok());
                }
                try {
                    System.out.print("Masukkan nomor indeks barang: ");
                    int indeks = sc.nextInt();
                    sc.nextLine();

                    if (indeks < daftarBarang.size()) {
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlah = sc.nextInt();
                        sc.nextLine();

                        Barang baru = daftarBarang.get(indeks);
                        if (jumlah > baru.getStok()) {
                            throw new StokTidakCukupException("Stok tidak cukup! Hanya tersedia " + baru.getStok());

                        }
                        baru.setStok(baru.getStok() - jumlah);
                        System.out.println("Stok barang '" + baru.getNama() + "' berhasil dikurangi. Sisa stok : " + baru.getStok());
                    } else {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input jumlah dan nomor harus berupa angka!");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Indeks tersebut tidak ada");
                } catch (StokTidakCukupException e) {
                    System.out.println(e.getMessage());
                }

            }
        }while (pilih != 4) ;
        }
}
