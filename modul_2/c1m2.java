import java.util.Scanner;


class Hewan {

    String Nama;
    String Jenis;
    String Suara;

    public Hewan(String n, String j, String s){
        Nama = n;
        Jenis = j;
        Suara = s;

    }

    public void tampilkainfo(){
        System.out.println("Nama: " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
        System.out.println();

    }
}

public class c1m2 {

    public static void main(String[] args) {
    
        Scanner objinput = new Scanner(System.in);

        System.out.print("Masukkan Nama Hewan: ");
        String nama1 = objinput.nextLine();
        System.out.print("Masukkan Jenis Hewan: ");
        String jenis1 = objinput.nextLine();
        System.out.print("Masukkan Suara Hewan: ");
        String suara1 = objinput.nextLine();

        Hewan hewan1 = new Hewan(nama1, jenis1, suara1);

        System.out.print("Masukkan Nama Hewan: ");
        String nama2 = objinput.nextLine();
        System.out.print("Masukkan Jenis Hewan: ");
        String jenis2 = objinput.nextLine();
        System.out.print("Masukkan Suara Hewan: ");
        String suara2 = objinput.nextLine();

        Hewan hewan2 = new Hewan(nama2, jenis2, suara2);

        hewan1.tampilkainfo();
        hewan2.tampilkainfo();

        objinput.close();

    }
    
}

