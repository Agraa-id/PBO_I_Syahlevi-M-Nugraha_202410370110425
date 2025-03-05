import java.util.Scanner;
import java.time.LocalDateTime;

public class m1c1{
    public static void main(String[] args){
        String nama;
        String jenis_kelamin;
        int tahun_kelahiran;

        Scanner objinput = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        nama = objinput.nextLine();

        System.out.print("Masukkan jenis kelamin (p/l): ");
        jenis_kelamin = objinput.nextLine();

        char jk = jenis_kelamin.charAt(0);

        System.out.print("Masukkan tahun kelahiran: ");
        tahun_kelahiran = objinput.nextInt();
        objinput.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();
        int umur = dateTime.getYear() - tahun_kelahiran;

        //string kel = (jk == 'l' || jk == 'L') ? "Laki - Laki" : "Perempuan";

        System.out.println("Data Diri: ");
        System.out.println("Nama: " + nama);
        
        if (jk == 'l' || jk == 'L'){
            System.out.println("Jenis kelamin: Laki - Laki");
        }else{
            System.out.println("Jenis kelamin: Perempuan");
        }
    
        //System.out.println("Jenis Kelamin: " + kel);
        System.out.println("Umur: " + umur);

        objinput.close();

    }
}