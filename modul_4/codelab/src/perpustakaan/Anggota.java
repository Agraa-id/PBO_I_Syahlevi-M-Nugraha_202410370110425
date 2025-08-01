package perpustakaan;

public class Anggota implements Peminjaman{

    String nama;
    String idAnggota;

    public Anggota(String nama, String idAnggota){

        this.nama = nama;
        this.idAnggota = idAnggota;

    }

    public void display(){
        System.out.println("Anggota: " + nama + "(ID: " + idAnggota + ")");
    }

    @Override
    public void pinjamBuku(String judul){
        System.out.println(nama + " meminjam buku berjudul: " + judul);
    }

    public void pinjamBuku(String judul, int durasi){
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi +" hari");
    }

    @Override
    public void kembalikanBuku(String judul){
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }
}
