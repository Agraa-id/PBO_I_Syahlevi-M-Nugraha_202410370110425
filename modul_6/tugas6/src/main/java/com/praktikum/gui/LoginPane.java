package main.java.com.praktikum.gui;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.java.com.praktikum.main.LoginSystem;
import main.java.com.praktikum.users.*;

public class LoginPane {
    public LoginPane(Stage stage) {
        Label lblUser = new Label("Username:");
        TextField tfUser = new TextField();
        Label lblPass = new Label("Password:");
        PasswordField pfPass = new PasswordField();
        Label lblInfo = new Label();
        Button btnLogin = new Button("Login");

        btnLogin.setOnAction(e -> {
            String username = tfUser.getText();
            String password = pfPass.getText();
            User user = LoginSystem.login(username, password);

            if (user == null) {
                lblInfo.setText("Login gagal.");
            } else if (user instanceof Admin) {
                new AdminDashboard(stage);
            } else if (user instanceof Mahasiswa) {
                new MahasiswaDashboard(stage, (Mahasiswa) user);
            }
        });

        VBox root = new VBox(10, lblUser, tfUser, lblPass, pfPass, btnLogin, lblInfo);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 300, 250));
        stage.setTitle("Login");
        stage.show();
    }
}