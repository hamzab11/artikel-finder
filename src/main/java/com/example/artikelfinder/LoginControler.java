package com.example.artikelfinder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginControler {


        @FXML
        private TextField usernameField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button loginButton;

        @FXML
        private void handleLogin() throws IOException {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.equals("admin") && password.equals("1234")) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/example/artikelfinder/hello-view.fxml")
                );

                Stage mainStage = new Stage();
                Scene scene = new Scene(loader.load(), 1000, 750);

                mainStage.setTitle("Artikel Finder");
                mainStage.setScene(scene);
                mainStage.setResizable(false);
                mainStage.show();

                Stage loginStage = (Stage) loginButton.getScene().getWindow();
                loginStage.close();

            } else {
                System.out.println("Wrong username or password");
            }
        }
    }


