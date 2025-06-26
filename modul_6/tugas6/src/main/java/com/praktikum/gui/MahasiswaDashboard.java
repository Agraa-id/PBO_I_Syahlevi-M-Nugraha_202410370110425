package main.java.com.praktikum.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.com.praktikum.users.Mahasiswa;

public class MahasiswaDashboard {
    public MahasiswaDashboard(Stage stage, Mahasiswa mhs) {
        Label l1 = new Label("Dashboard Mahasiswa");
        Label l2 = new Label("Nama: " + mhs.getNama());
        Label l3 = new Label("NIM: " + mhs.getNim());
        Label l4 = new Label("Jurusan: " + mhs.getJurusan());

        VBox root = new VBox(10, l1, l2, l3, l4);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        stage.setScene(new Scene(root, 400, 200));
        stage.setTitle("Dashboard Mahasiswa");
        stage.show();
    }
}