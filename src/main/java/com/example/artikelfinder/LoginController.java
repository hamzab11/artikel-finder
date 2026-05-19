package com.example.artikelfinder;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController extends UiHelper {
    @FXML
    public Label dateValueLabel;

    public Label timeValueLabel;
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
        TimeAndDateManager timeAndDateManager = new TimeAndDateManager();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),event -> {
            timeValueLabel.setText(timeAndDateManager.getCurrentTime());
            dateValueLabel.setText(timeAndDateManager.getCurrentDate());
        })
        );
                timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/artikelfinder/main-view.fxml"));

            Stage mainStage = new Stage();
            Scene scene = new Scene(loader.load(), 520, 280);

            mainStage.setTitle("Artikel Finder");
            mainStage.setScene(scene);
            mainStage.setResizable(false);
            mainStage.show();

            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();

        } else {
            AnimationManager.shake(fieldLog, 50, -5, 5, 10, true);
            //fieldLog.setText("Wrong username or password!")
            displayText(fieldLog, "Wrong username or password!")

            ;

        }
    }

    public void openRegisterWindow(ActionEvent actionEvent) {
        try {
            SceneManager.switchScene(actionEvent, "register-view.fxml");

        }catch (IOException e) {
            displayText(fieldLog, "Error!");
        }
    }
}


