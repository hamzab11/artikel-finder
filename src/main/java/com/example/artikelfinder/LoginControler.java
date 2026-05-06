package com.example.artikelfinder;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginControler {

    @FXML
    private VBox loginForm;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    @FXML
    private Label fieldLog;

    @FXML
    public void initialize() {
        animateForm();
        AnimationManager.nodeHover(loginButton);
    }

    // ✨ دخول الفورم
    private void animateForm() {
        loginForm.setOpacity(0);
        loginForm.setTranslateX(100);

        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), loginForm);
        fade.setToValue(1);

        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.8), loginForm);
        slide.setToX(0);

        new ParallelTransition(fade, slide).play();
    }




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
            AnimationManager.shake(fieldLog,50,-5,5,10,true);
            fieldLog.setText("Wrong username or password!");

        }
    }
}


