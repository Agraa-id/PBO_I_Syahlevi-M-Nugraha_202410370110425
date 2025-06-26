package com.example.login1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Login");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        Label statusLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals("admin") && password.equals("1234")) {
                statusLabel.setText("Login berhasil!");
            } else {
                statusLabel.setText("Login gagal. Coba lagi.");
            }
        });;

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, usernameField, passwordField, loginButton, statusLabel);

        Scene scene = new Scene(layout, 300, 200);
        stage.setTitle("Login App");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}