import java.util.Scanner;
class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public boolean login(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Informasi Pengguna:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

class Admin extends User {
    private String password;

    public Admin(String nama, String nim, String password) {
        super(nama, nim); 
        this.password = password;
    }

    @Override
    public boolean login(String inputNama, String inputPassword) {
        return getNama().equals(inputNama) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil");
        System.out.println("Username: " + getNama());
    }
}

class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa Berhasil");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}

// Main class
public class t1m3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Admin admin = new Admin("admin", "0001", "admin123");
        Mahasiswa mahasiswa = new Mahasiswa("Syahlevi M Nugraha", "425");

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih (1/2): ");
        int pilihan = input.nextInt();
        input.nextLine(); 

        if (pilihan == 1) {
            System.out.print("Masukkan Username: ");
            String username = input.nextLine();
            System.out.print("Masukkan Password: ");
            String password = input.nextLine();

            if (admin.login(username, password)) {
                admin.displayInfo();
            } else {
                System.out.println("Login Admin Gagal");
            }

        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama Mahasiswa: ");
            String nama = input.nextLine();
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = input.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login Mahasiswa Gagal");
            }

        } else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}
