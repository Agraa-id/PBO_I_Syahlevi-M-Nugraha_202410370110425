package main.java.com.praktikum.gui;

import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.users.*;

public class AdminDashboard {
    public AdminDashboard(Stage stage) {
        TableView<Mahasiswa> table = new TableView<>();

        TableColumn<Mahasiswa, String> colNIM = new TableColumn<>("NIM");
        colNIM.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(((Mahasiswa) data.getValue()).getNim()));

        TableColumn<Mahasiswa, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(((Mahasiswa) data.getValue()).getNama()));

        TableColumn<Mahasiswa, String> colJurusan = new TableColumn<>("Jurusan");
        colJurusan.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(((Mahasiswa) data.getValue()).getJurusan()));

        table.getColumns().addAll(colNIM, colNama, colJurusan);

        ObservableList<Mahasiswa> list = FXCollections.observableArrayList();
        for (User user : DataStore.getAllUsers()) {
            if (user instanceof Mahasiswa) list.add((Mahasiswa) user);
        }

        table.setItems(list);

        VBox root = new VBox(10, new Label("Data Mahasiswa"), table);
        root.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(root, 500, 300));
        stage.setTitle("Dashboard Admin");
        stage.show();
    }
}
