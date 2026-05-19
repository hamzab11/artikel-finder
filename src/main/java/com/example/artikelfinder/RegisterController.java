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
        try {
            String email = extractText(emailField);
            String confirmEmail = extractText(confirmEmailField);
            String password =  extractText(passwordField);
            String confirmPassword = extractText(confirmPasswordField);
            String eResult = RegisterService.checkEmail(email,confirmEmail);
            String pResult = RegisterService.checkPassword(password,confirmPassword);
            System.out.println("every thing is ok");
        }catch (Exception e){
            displayText(registerLabel,"error");
        }
    }

    public void backToLogin(ActionEvent actionEvent) {
       try {
          SceneManager.switchScene(actionEvent, "login-view.fxml");
       }catch (Exception e){
           displayText(registerLabel, "Error!");
       }

    }




}
