package com.javaguides.javafx.registration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	System.out.println(getClass());
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/registration_form.fxml"));
        stage.setTitle("User Registration");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
