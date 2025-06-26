import java.util.Scanner;

public class m1t1 {
    public static void main(String[] args){

        int pilihan;
        String Username = "Admin425";
        String Password = "Password425";
        String Nama = "Syahlevi M Nugraha";
        long NIM = 202410370110425l;

        Scanner objInput = new Scanner(System.in);

        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih opsi anda (1/2): ");
        pilihan = objInput.nextInt();
        objInput.nextLine();

         switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String username = objInput.nextLine();
                System.out.print("Masukkan password: ");
                String password = objInput.nextLine();

                if(username.equals(Username) && password.equals(Password)){
                    System.out.println("Login anda berhasil");
                } else {
                    System.out.println("Login gagal! username atau password salah");
                } break;
                
            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = objInput.nextLine();
                System.out.print("Masukkan NIM: ");
                long nim = objInput.nextLong();

                if(nama.equals(Nama) && nim == NIM){
                    System.out.println("Login Mahasiswa Berhasil!");
                    System.out.println("Nama: " + nama);
                    System.out.println("NIM: " + NIM);
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah");
                } break;


            default:
                System.out.println("Input tidak valid!");
                break;
         }
         objInput.close();
    }
}
//
