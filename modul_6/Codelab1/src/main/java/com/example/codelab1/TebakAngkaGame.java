package com.example.codelab1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaGame extends Application {
    int angkaAcak = new Random().nextInt(100) + 1;
    int jumlahPercobaan = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tebak Angka Advance");

        Label judul = new Label("🎯 Tebak Angka 1–100");
        judul.setFont(new Font("Arial", 22));
        judul.setTextFill(Color.web("#0033cc"));


        Label tebakLabel = new Label("Masukkan tebakanmu:");
        Label percobaanLabel = new Label("Jumlah percobaan: 0");

        TextField inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");

        Button tebakButton = new Button("Coba Tebak!");

        HBox inputArea = new HBox();
        inputArea.setAlignment(Pos.CENTER);
        inputArea.getChildren().addAll(inputField, tebakButton);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #e6f0ff;");
        root.getChildren().addAll(judul, tebakLabel, inputArea, percobaanLabel);

        tebakButton.setOnAction(e -> {
            if (tebakButton.getText().equals("Main Lagi")) {
                angkaAcak = new Random().nextInt(100) + 1;
                jumlahPercobaan = 0;
                percobaanLabel.setText("Jumlah percobaan: 0");
                tebakLabel.setText("Masukkan tebakanmu:");
                inputField.setDisable(false);
                inputField.clear();
                tebakButton.setText("Coba Tebak!");
                return;
            }

            String input = inputField.getText();
            try {
                int tebakan = Integer.parseInt(input);
                jumlahPercobaan++;
                percobaanLabel.setText("Jumlah percobaan: " + jumlahPercobaan);

                if (tebakan > angkaAcak) {
                    tebakLabel.setText("🔽 Terlalu besar!");
                } else if (tebakan < angkaAcak) {
                    tebakLabel.setText("🔼 Terlalu kecil!");
                    tebakLabel.setTextFill(Color.web("#cc6600"));

                } else {
                    tebakLabel.setText("✅ Tebakan benar!");
                    inputField.setDisable(true);
                    tebakButton.setText("🔁 Main Lagi");
                }
            } catch (NumberFormatException ex) {
                tebakLabel.setText("Masukkan angka valid!");
            }
        });

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
