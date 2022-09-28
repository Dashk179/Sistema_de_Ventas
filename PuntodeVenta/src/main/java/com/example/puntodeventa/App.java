package com.example.puntodeventa;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               stage.setX(event.getScreenX() - xOffset);
               stage.setY(event.getScreenY() - yOffset);

            }
        });



        stage.setTitle("Inicio de Sesion");
        stage.setScene(scene);
        stage.show();
        Image icono = new Image(getClass().getResourceAsStream("img/venta.png"));
        stage.getIcons().add(icono);
    }

    public static void main(String[] args) {
        launch();
    }
}