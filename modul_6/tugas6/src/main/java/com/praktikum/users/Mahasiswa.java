package main.java.com.praktikum.users;

public class Mahasiswa extends User {
    private String nama;
    private String nim;
    private String jurusan;

    public Mahasiswa(String username, String password, String nama, String nim, String jurusan) {
        super(username, password);
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getJurusan() { return jurusan; }
}
