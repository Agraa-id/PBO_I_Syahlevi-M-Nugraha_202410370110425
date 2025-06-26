import java.util.Scanner;

class Admin {
    String username = "admin";
    String password = "admin123";

    public boolean login(String u, String p ){
        return u.equals(username) && p.equals(password);
    }
}

class Mahasiswa {
    String nama = "Syahlevi M Nugraha";
    String nim = "202410370110425";

    public boolean login(String na, String ni){
        return na.equals(nama) && ni.equals(nim);
    }

    void displayInfo(){
        System.out.println("Login berhasil!");
        System.out.println("Nama: "+ nama);
        System.out.println("Nim: " + nim);
    }
}

public class t1m2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa =  new Mahasiswa();

        System.out.println("Pilih jenis login: \n1. Admin \n2. Mahasiswa");
        System.out.print("pilih: ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        if(pilih == 1){
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                System.out.println("Login anda berhasil");
            }else {
                System.out.println("Usernam atau password salah!");
            }
        }else if(pilih == 2){
            System.out.println("Masukkan nama: ");
            String nama = scanner.nextLine();
            System.out.println("Masukkan nim: ");
            String nim = scanner.nextLine();

            if(mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
            }else {
                System.out.println("Nama atau nim sala!");
            }
        }else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();

    }
}
