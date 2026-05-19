package com.example.artikelfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController extends UiHelper{
    @FXML
    public TextField emailField;
    @FXML
    public TextField confirmEmailField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField confirmPasswordField;
   @FXML
    public Label registerLabel;


    public void handleRegister(ActionEvent actionEvent) {
    }

    public void backToLogin(ActionEvent actionEvent) {
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
           Stage stage = new Stage();
           Scene scene = new Scene(fxmlLoader.load(), 1440, 900);
           stage.setTitle("Artikerl finder");
           stage.setScene(scene);
           stage.setResizable(false);
           stage.show();
       }catch (Exception e){
           displayText(registerLabel, "Error!");
       }

    }
}
