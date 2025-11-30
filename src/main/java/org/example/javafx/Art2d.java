package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Art2d extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Art2d.class.getResource("art2d-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setMinWidth(320);
        stage.setMinHeight(330);

        stage.setTitle("Art2d");
        stage.setScene(scene);
        stage.show();
    }
}