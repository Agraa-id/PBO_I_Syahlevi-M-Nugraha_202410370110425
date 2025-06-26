package com.example.extra_task;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CatatanKesehatanApp extends Application {

    private TableView<CatatanKesehatan> table;
    private ObservableList<CatatanKesehatan> dataList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Input Fields
        TextField tfTanggal = new TextField();
        tfTanggal.setPromptText("Tanggal (dd-mm-yyyy)");

        TextField tfBeratBadan = new TextField();
        tfBeratBadan.setPromptText("Berat Badan");

        TextField tfTekananDarah = new TextField();
        tfTekananDarah.setPromptText("Tekanan Darah (contoh: 120/80)");

        TextArea taCatatan = new TextArea();
        taCatatan.setPromptText("Catatan Tambahan");
        taCatatan.setPrefRowCount(2);

        Button btnSimpan = new Button("Simpan");
        Button btnHapus = new Button("Hapus");

        // Table setup
        table = new TableView<>();
        dataList = FXCollections.observableArrayList();

        TableColumn<CatatanKesehatan, String> colTanggal = new TableColumn<>("Tanggal");
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        TableColumn<CatatanKesehatan, Double> colBerat = new TableColumn<>("Berat Badan");
        colBerat.setCellValueFactory(new PropertyValueFactory<>("beratBadan"));

        TableColumn<CatatanKesehatan, String> colTekanan = new TableColumn<>("Tekanan Darah");
        colTekanan.setCellValueFactory(new PropertyValueFactory<>("tekananDarah"));

        TableColumn<CatatanKesehatan, String> colCatatan = new TableColumn<>("Catatan");
        colCatatan.setCellValueFactory(new PropertyValueFactory<>("catatan"));

        table.getColumns().addAll(colTanggal, colBerat, colTekanan, colCatatan);
        table.setItems(dataList);
        table.setPrefHeight(200);

        // Save Button Action
        btnSimpan.setOnAction(e -> {
            String tanggal = tfTanggal.getText().trim();
            String beratText = tfBeratBadan.getText().trim();
            String tekanan = tfTekananDarah.getText().trim();
            String catatan = taCatatan.getText().trim();

            if (tanggal.isEmpty() || beratText.isEmpty() || tekanan.isEmpty()) {
                showAlert("Input tidak lengkap!", Alert.AlertType.ERROR);
                return;
            }

            double berat;
            try {
                berat = Double.parseDouble(beratText);
            } catch (NumberFormatException ex) {
                showAlert("Berat badan harus berupa angka!", Alert.AlertType.ERROR);
                return;
            }

            CatatanKesehatan catatanBaru = new CatatanKesehatan(tanggal, berat, tekanan, catatan);
            dataList.add(catatanBaru);

            tfTanggal.clear();
            tfBeratBadan.clear();
            tfTekananDarah.clear();
            taCatatan.clear();
        });

        // Delete Button Action
        btnHapus.setOnAction(e -> {
            CatatanKesehatan selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                dataList.remove(selected);
            } else {
                showAlert("Pilih data yang ingin dihapus.", Alert.AlertType.WARNING);
            }
        });

        // Layout
        VBox inputBox = new VBox(10,
                tfTanggal, tfBeratBadan, tfTekananDarah, taCatatan, btnSimpan, btnHapus);
        inputBox.setPadding(new Insets(10));
        inputBox.setPrefWidth(250);

        BorderPane root = new BorderPane();
        root.setLeft(inputBox);
        root.setCenter(table);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 700, 350);
        primaryStage.setTitle("Aplikasi Catatan Kesehatan Harian");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Informasi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
