package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args){
        NonFiksi buku1 = new NonFiksi("Madilog", "Tan malaka", "Sejarah & ilmu pengetahuan");
        Fiksi buku2 = new Fiksi("Hainuwele: Sang putri kelapa", "Lilis hu ", "Dongeng");

        System.out.println();

        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();

        Anggota nama1 = new Anggota("Agraa", "I425");
        Anggota nama2 = new Anggota("Sherine", "E467");

        nama1.display();
        nama2.display();

        System.out.println();

        nama1.pinjamBuku("Madilog");
        nama2.pinjamBuku("Hainuwele: Sang putri kelapa", Integer.parseInt("7"));

        System.out.println();

        nama1.kembalikanBuku("Madilog");
        nama2.kembalikanBuku("Hainuwele: Sang putri kelapa");
    }


}
