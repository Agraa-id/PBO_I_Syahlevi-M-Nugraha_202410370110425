//import java.util.Scanner;

class RekeningBank{

    String nomorRekening;
    String namaPemilik;
    double saldo;

    public RekeningBank(String nr, String np, Double s){
        nomorRekening = nr;
        namaPemilik = np;
        saldo = s;
    }

    void tampilkainfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
        
    }

    void setorUang(Double jumlah){
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    void tarikUang(Double jumlah){
        if(jumlah > saldo){
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak cukup) Saldosaat ini: Rp" + saldo);
        }else {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: " + saldo);
        }
    }
}

public class c2m2 {
    public static void main(String[] args) {
        
        RekeningBank rekening1 = new RekeningBank("202410370110425", "Agraa", 500000.0);
        RekeningBank rekening2 = new RekeningBank("202410160110467", "Sherine", 1000000.0);

        rekening1.tampilkainfo();
        rekening2.tampilkainfo();

        System.out.println();

        rekening1.setorUang(200000.0);
        rekening2.setorUang(500000.0);

        System.out.println();

        rekening1.tarikUang(800000.0);
        rekening2.tarikUang(300000.0);

        System.out.println();

        rekening1.tampilkainfo();
        rekening2.tampilkainfo();

    }
}
