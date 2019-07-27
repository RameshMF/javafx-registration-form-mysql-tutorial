package com.javaguides.javafx.registration;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class RegisterController {
    
    @FXML
    private TextField fullNameField;
    
    @FXML
    private TextField emailIdField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button submitButton; 	
    
    @FXML
    public void register(ActionEvent event) throws SQLException{
    
    	Window owner = submitButton.getScene().getWindow();
    	
    	System.out.println(fullNameField.getText());
    	System.out.println(emailIdField.getText());
    	System.out.println(passwordField.getText());
    	if(fullNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your name");
            return;
        }
    	
    	if(emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a password");
            return;
        }
        
    	String fullName = fullNameField.getText();
    	String emailId = emailIdField.getText();
    	String password = passwordField.getText();
    	
    	JdbcDao jdbcDao = new JdbcDao();
    	jdbcDao.insertRecord(fullName, emailId, password);
    	
    	showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", 
                "Welcome " + fullNameField.getText());
    }
    
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
